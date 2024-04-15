package hk.hku.api.member;


import hk.hku.api.base.BaseResponse;
import hk.hku.api.member.req.UserReqDto;
import hk.hku.api.member.resp.UserRespDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @PostMapping("updateUserDto")
    BaseResponse<UserRespDto> updateUserDto(@RequestBody UserReqDto userReqDto);

    @RequestMapping("/getTestConfig")
    String getTestConfig();
}