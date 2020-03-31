package priv.geekjoker.joy.blog.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import priv.geekjoker.joy.blog.vo.User;

import java.util.List;

@Mapper
@Component
public interface UserSelectMapper {

    List<User> listUser();

    /**
     * 通过id 获取 一个用户
     * @param id
     * @return
     */
    User selectUserById(Long id);

    /**
     * 通过 nickname 获取一个用户
     * @param nickname
     * @return
     */
    User selectUserByNickname(String nickname);

}
