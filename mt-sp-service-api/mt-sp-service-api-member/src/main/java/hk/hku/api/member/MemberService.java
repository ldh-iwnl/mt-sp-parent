package hk.hku.api.member;


import hk.hku.api.base.BaseResponse;
import org.springframework.web.bind.annotation.GetMapping;

public interface MemberService {

    @GetMapping("memberToWeiXin")
    String memberToWeiXin(Integer a);

    /**
     * 不符合规范
     * @return
     */
    @GetMapping("addMember")
    BaseResponse<String> addMember(String userName, String pwd,Integer age);
}