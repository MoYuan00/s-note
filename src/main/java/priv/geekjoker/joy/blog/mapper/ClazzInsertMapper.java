package priv.geekjoker.joy.blog.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import priv.geekjoker.joy.blog.vo.Clazz;

@Mapper
@Component
public interface ClazzInsertMapper {
    /**
     * 插入一个 笔记类型
     * 并且 回填插入自动生成的主键
     * @param clazz
     * @return
     */
    boolean clazzInsert(Clazz clazz);
}
