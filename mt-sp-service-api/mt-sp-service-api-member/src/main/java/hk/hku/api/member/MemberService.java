package hk.hku.api.member;


import hk.hku.api.base.BaseResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

public interface MemberService {

    @GetMapping("memberToWeiXin")
    String memberToWeiXin(Integer a);

    /**
     * 不符合规范
     * @return
     */
    @GetMapping("addMember")
    BaseResponse<String> addMember(String userName, String pwd,Integer age);

    @PostMapping("updateUser")
    Object updateUser(@RequestBody Map<String, String> map);
}