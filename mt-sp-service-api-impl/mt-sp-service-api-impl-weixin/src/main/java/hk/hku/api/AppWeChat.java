package hk.hku.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author kyleli
 * @ClassName AppWeChat
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class AppWeChat {
    public static void main(String[] args) {
        SpringApplication.run(AppWeChat.class);
    }
}
