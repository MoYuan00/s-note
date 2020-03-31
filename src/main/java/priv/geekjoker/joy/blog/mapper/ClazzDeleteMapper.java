package priv.geekjoker.joy.blog.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import priv.geekjoker.joy.blog.vo.Clazz;

@Mapper
@Component
public interface ClazzDeleteMapper {
    /**
     * 删除一个 笔记类型
     * @param id
     * @return
     */
    boolean classDeleteById(Long id);
}
