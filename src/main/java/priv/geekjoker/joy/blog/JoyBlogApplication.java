package priv.geekjoker.joy.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author -ZQ-
 */
@SpringBootApplication
@MapperScan("priv.geekjoker.joy.blog.mapper")
public class JoyBlogApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(JoyBlogApplication.class, args);
    }
    /**
     *新增此方法
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        // 注意这里要指向原先用main方法执行的Application启动类
        return builder.sources(JoyBlogApplication.class);
    }
}
