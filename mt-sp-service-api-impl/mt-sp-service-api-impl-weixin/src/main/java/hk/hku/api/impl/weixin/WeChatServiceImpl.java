package hk.hku.api.impl.weixin;

/**
 * @author kyleli
 * @ClassName WeChatServiceImpl
 */
import hk.hku.api.weixin.WeChatService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeChatServiceImpl implements WeChatService {
    @Override
    public String getWeChat(Integer a) {
        return "每特教育微信服务a:"+a;
    }
}
