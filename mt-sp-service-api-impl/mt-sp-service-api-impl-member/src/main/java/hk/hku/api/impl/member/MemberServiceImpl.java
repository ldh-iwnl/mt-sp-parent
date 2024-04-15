package hk.hku.api.impl.member;

import com.alibaba.fastjson.JSON;
import hk.hku.api.base.BaseApiService;
import hk.hku.api.base.BaseResponse;
import hk.hku.api.impl.entity.UserDo;
import hk.hku.api.impl.feign.WeChatServiceFeign;
import hk.hku.api.impl.mapper.UserMapper;
import hk.hku.api.member.MemberService;
import hk.hku.api.member.req.UserReqDto;
import hk.hku.api.member.resp.UserRespDto;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class MemberServiceImpl extends BaseApiService implements MemberService {
    @Autowired
    private WeChatServiceFeign weChatServiceFeign;

    @Autowired
    private UserMapper userMapper;

    @Value("${mayikt.userName}")
    private String userName;

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

    @Override
    public Object updateUser(Map<String, String> map) {
        UserDo userDo1 = userMapper.selectById(1);
        String jsonString = JSON.toJSONString(map);
        UserDo user = JSON.parseObject(jsonString, UserDo.class);
        Integer userId = user.getUserId();
        if (userId == null) {
            return setResultError("userId is null");
        }
        System.out.println(user);
        int result = userMapper.updateById(user);
        if (result < 0) {
            return setResultError("修改失败");
        }
        UserDo userDo = userMapper.selectById(userId);
        return userDo == null ? setResultError("查询修改数据失败"): setResultSuccess(String.valueOf(userDo));
    }

    @Override
    public BaseResponse<UserRespDto> updateUserDto(UserReqDto userReqDto) {
        // 1.验证参数
        // 2.userReqDto 转换成 do
        UserDo userReqDo = dtoToDo(userReqDto, UserDo.class);
        if (userMapper.updateById(userReqDo) <= 0) {
            return setResultError("修改失败");
        }
        //2.查询最新的修改的数据直接返回
        Integer userId = userReqDo.getUserId();
        UserDo userRespDo = userMapper.selectById(userId);
        //3.do转换成dto
        UserRespDto userRespDto = doToDto(userRespDo, UserRespDto.class);
        return userRespDto == null ? setResultError("查询修改数据失败") : setResultSuccess(userRespDto);
    }

    @Override
    public String getTestConfig() {
        return userName;
    }

}