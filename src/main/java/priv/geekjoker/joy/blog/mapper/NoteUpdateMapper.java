package priv.geekjoker.joy.blog.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import priv.geekjoker.joy.blog.vo.Note;

import java.util.List;

@Mapper
@Component
public interface NoteUpdateMapper {
    public boolean noteUpdate(Note note);
}
