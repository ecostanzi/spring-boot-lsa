package org.encos.lsa.utils;

import org.encos.lsa.LazySundayAfternoon;
import org.encos.lsa.test.WebBaseTest;
import org.encos.lsa.test.category.DevTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManager;

/**
 * @author Enrico Costanzi
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(value = LazySundayAfternoon.class)
@Category(DevTest.class)
public class JpaSchemaExportTest extends WebBaseTest{

    @Autowired
    EntityManager entityManager;

    @Test
    public void testDDL(){
        JpaSchemaExport generator = new JpaSchemaExport(entityManager);
        generator.generate();
    }
}
