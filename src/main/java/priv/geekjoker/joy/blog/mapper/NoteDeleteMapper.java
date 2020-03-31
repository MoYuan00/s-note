package priv.geekjoker.joy.blog.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface NoteDeleteMapper {
    /**
     * 通过 id 删除 一条笔记
     * @param id
     * @return
     */
    boolean deleteNoteById(Long id);

    /**
     * 通过 类型 id 删除 多条 笔记
     * @param clazzId
     * @return
     */
    int deleteNoteByClazzId(
            Long clazzId);
}
