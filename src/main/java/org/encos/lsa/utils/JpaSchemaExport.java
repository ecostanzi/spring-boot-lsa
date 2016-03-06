package org.encos.lsa.utils;

import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.H2Dialect;
import org.hibernate.dialect.Oracle10gDialect;
import org.hibernate.dialect.PostgreSQL9Dialect;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.Table;
import javax.persistence.metamodel.EntityType;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class JpaSchemaExport {

    private static final String DEFAULT_DDL_LOCATION = "db/ddl";

    private final Logger logger = LoggerFactory.getLogger(JpaSchemaExport.class);

    private EntityManager em;

    public JpaSchemaExport(EntityManager em) {
        this.em = em;
    }

    private final Class<? extends Dialect> oracle = Oracle10gDialect.class;
    private final Class<? extends Dialect> postgres = PostgreSQL9Dialect.class;
    private final Class<? extends Dialect> h2 = H2Dialect.class;

    public void generate(String location, Class<? extends Dialect>... dialects){
        List<Class<? extends Dialect>> dialectList;
        if(dialects.length == 0) {
            dialectList = Arrays.asList(oracle, h2, postgres);
        } else{
            dialectList = Arrays.asList(dialects);
        }
        Set<EntityType<?>> entities = em.getMetamodel().getEntities();

        for (Class<? extends Dialect> dialect : dialectList) {
            try {
                execute(dialect, entities, location);
            } catch (IOException e) {
                logger.error("Error creating DDL for entities " + entities + " with dialect [" + dialect + "]", e);
            }
        }

    }

    public void generate() {
        generate(DEFAULT_DDL_LOCATION, oracle, h2, postgres);
    }

    private void execute(Class<? extends Dialect> dialectClass, Set<EntityType<?>> entities, String path) throws IOException {
        Configuration cfg = new Configuration();
        cfg.setProperty(Environment.DIALECT, dialectClass.getCanonicalName());
        for (EntityType<?> entityClass : entities) {
            logger.debug("Found entity [{}]", entityClass.getJavaType());
            Annotation[] declaredAnnotations = entityClass.getJavaType().getDeclaredAnnotations();
            for (Annotation declaredAnnotation : declaredAnnotations) {
                Class<? extends Annotation> annotationType = declaredAnnotation.annotationType();
                if(annotationType.equals(javax.persistence.Table.class) || annotationType.equals(org.hibernate.annotations.Table.class)){
                    cfg.addAnnotatedClass(entityClass.getJavaType());
                }
            }

        }

        Path outdir = Paths.get(path);

        if ( !Files.exists(outdir) ){
            Files.createDirectories(outdir);
        }

        SchemaExport se = new SchemaExport(cfg);
        se.setDelimiter(";");
        se.setOutputFile(String.format(path + "/%s.%s ", dialectClass.getSimpleName() , "sql"));

        boolean consolePrint = logger.isDebugEnabled();
        se.setFormat(true);
        se.create(consolePrint, false);
    }

}