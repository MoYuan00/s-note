package priv.geekjoker.joy.blog.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import priv.geekjoker.joy.blog.vo.Clazz;

@Mapper
@Component
public interface ClazzUpdateMapper {
    /**
     * 更新一个 笔记类型
     * @param clazz
     * @return
     */
    boolean clazzUpdate(Clazz clazz);
}
