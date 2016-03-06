package org.encos.lsa;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Enrico Costanzi
 */
@SpringBootApplication
public class LazySundayAfternoon extends SpringBootServletInitializer {

    public final static String APP_NAME = "lsa";

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        Map<String, Object> map = new HashMap<>();
        map.put("spring.config.location", "classpath:" + APP_NAME + "/");
        map.put("spring.config.name", APP_NAME);
        return application
                .properties(map)
                .bannerMode(Banner.Mode.OFF)
                .sources(LazySundayAfternoon.class);
    }
    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        map.put("spring.config.name", APP_NAME);
        new SpringApplicationBuilder().
                sources(LazySundayAfternoon.class)
                .properties(map)
                .bannerMode(Banner.Mode.OFF)
                .run(args);
    }
}
