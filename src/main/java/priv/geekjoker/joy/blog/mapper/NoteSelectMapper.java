package priv.geekjoker.joy.blog.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import priv.geekjoker.joy.blog.vo.Note;

import java.util.List;

@Mapper
@Component
public interface NoteSelectMapper {

    /**
     * 获取全部的笔记
     * @return
     */
    public List<Note> listNote();

    /**
     * 通过 note id 获取一条笔记
     * @param id
     * @return
     */
    Note selectNoteById(Long id);

    /**
     * 通过用户 id 获取 用户的所有笔记
     * @param userId
     * @return
     */
    List<Note> listNoteByUserId(Long userId);

    /**
     * 通过用户 id 和分类 获取 用户的某类笔记
     * @param userId
     * @param clazzId
     * @return
     */
    List<Note> listNoteByUserIdAndClazzId(
            @Param("userId") Long userId,
            @Param("clazzId") Long clazzId);

    /**
     * 通过 用户名 和 id 获取 某个笔记
     * 可以帮助判断该用户是否有此笔记
     * @param id
     * @param userId
     * @return
     */
    Note selectNoteByIdAndUserId(
            @Param("id") Long id,
            @Param("userId") Long userId);

}
