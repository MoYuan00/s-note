package priv.geekjoker.joy.blog.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import priv.geekjoker.joy.blog.vo.Note;

import java.util.List;

@Getter
@Setter
@ToString
public class ListNote {
    private List<Note> noteList;
    private List<NoteOperate> noteOperateList;
}
