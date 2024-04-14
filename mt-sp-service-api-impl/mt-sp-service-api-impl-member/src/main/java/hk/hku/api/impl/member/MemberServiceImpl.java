package hk.hku.api.impl.member;

import hk.hku.api.base.BaseApiService;
import hk.hku.api.base.BaseResponse;
import hk.hku.api.impl.feign.WeChatServiceFeign;
import hk.hku.api.member.MemberService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class MemberServiceImpl  extends BaseApiService<String> implements MemberService {
    @Autowired
    private WeChatServiceFeign weChatServiceFeign;
    @Override
    public String memberToWeiXin(Integer a) {
        return weChatServiceFeign.getWeChat(a);
    }

    @Override
    public BaseResponse<String> addMember(String userName, String pwd,Integer age) {
        if(StringUtils.isEmpty(userName)){
            return setResultError("userName is null error");
        }
        int j= 1/age;
        return setResultSuccess("success");
    }


}