package priv.geekjoker.joy.blog.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class UserLogin {
    private String nickname;
    private String password;

}
