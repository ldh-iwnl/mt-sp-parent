package hk.hku.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AppMember {
    public static void main(String[] args) {
        SpringApplication.run(AppMember.class);
    }
}