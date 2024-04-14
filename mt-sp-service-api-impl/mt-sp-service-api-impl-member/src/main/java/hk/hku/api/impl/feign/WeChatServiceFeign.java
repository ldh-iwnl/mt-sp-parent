package hk.hku.api.impl.feign;

import hk.hku.api.weixin.WeChatService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("mayikt-weixin")
public interface WeChatServiceFeign extends WeChatService {
//    @GetMapping("/getWeChat")
//    String getWeChat(@RequestParam("a") Integer a);
}