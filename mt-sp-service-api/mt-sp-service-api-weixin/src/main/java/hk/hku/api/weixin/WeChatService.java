package hk.hku.api.weixin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface WeChatService {

    @GetMapping("/getWeChat")
    String getWeChat(@RequestParam("a") Integer a);
}