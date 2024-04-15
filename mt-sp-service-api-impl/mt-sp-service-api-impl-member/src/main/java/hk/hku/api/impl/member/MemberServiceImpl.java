package hk.hku.api.impl.member;

import com.alibaba.fastjson.JSON;
import hk.hku.api.base.BaseApiService;
import hk.hku.api.base.BaseResponse;
import hk.hku.api.impl.entity.UserEntity;
import hk.hku.api.impl.feign.WeChatServiceFeign;
import hk.hku.api.impl.mapper.UserMapper;
import hk.hku.api.member.MemberService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
public class MemberServiceImpl extends BaseApiService<String> implements MemberService {
    @Autowired
    private WeChatServiceFeign weChatServiceFeign;

    @Autowired
    private UserMapper userMapper;


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
        UserEntity userEntity1 = userMapper.selectById(1);
        String jsonString = JSON.toJSONString(map);
        UserEntity user = JSON.parseObject(jsonString, UserEntity.class);
        Integer userId = user.getUserId();
        if (userId == null) {
            return setResultError("userId is null");
        }
        System.out.println(user);
        int result = userMapper.updateById(user);
        if (result < 0) {
            return setResultError("修改失败");
        }
        UserEntity userEntity = userMapper.selectById(userId);
        return userEntity == null ? setResultError("查询修改数据失败"): setResultSuccess(String.valueOf(userEntity));
    }


}