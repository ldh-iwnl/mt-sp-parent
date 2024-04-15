package hk.hku.api.member.req;

import lombok.Data;

@Data
public class UserReqDto {
    private Integer userId;
    private String userName;
    private Integer userAge;
    private String userAddres;
}