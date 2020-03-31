package priv.geekjoker.joy.blog.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import priv.geekjoker.joy.blog.vo.Note;

@Mapper
@Component
public interface NoteInsertMapper {
    boolean noteInsert(Note note);
}
