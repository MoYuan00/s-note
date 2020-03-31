package priv.geekjoker.joy.blog.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import priv.geekjoker.joy.blog.vo.Clazz;

import java.util.List;

@Mapper
@Component
public interface ClazzSelectMapper {
    /**
     * 通过 用户 id 查询， 用户 的所有笔记分类
     * @param userId
     * @return
     */
    List<Clazz> listClazzByUserId(Long userId);
}
