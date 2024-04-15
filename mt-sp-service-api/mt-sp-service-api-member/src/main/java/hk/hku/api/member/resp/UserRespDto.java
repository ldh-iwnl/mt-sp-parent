package hk.hku.api.member.resp;

import lombok.Data;

@Data
public class UserRespDto {
    private String userName;
    private Integer userAge;
    private String userAddres;
    private Integer userIntegral;
}