package priv.geekjoker.joy.blog.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import priv.geekjoker.joy.blog.vo.User;

@Mapper
@Component
public interface UserInsertMapper {
    boolean userInsert(User user);
}
