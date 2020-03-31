package priv.geekjoker.joy.blog.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class UserRegisterDTO {
    private String nickname;
    private String password;
}
