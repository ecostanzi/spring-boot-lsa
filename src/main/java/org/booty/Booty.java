package org.booty;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Enrico Costanzi
 */
@SpringBootApplication
public class Booty {

    public static void main(String[] args) {
        LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
        JoranConfigurator jc = new JoranConfigurator();
        jc.setContext(context);
        context.reset(); // override default configuration
        // inject the name of the current application as "application-name"
        // property of the LoggerContext
        context.putProperty("application-name", "booty");
        try {
            jc.doConfigure(Booty.class.getResourceAsStream("/logback-booty.xml"));
        } catch (JoranException e) {
            e.printStackTrace();
        }
        SpringApplication.run(Booty.class, args);
    }
}
