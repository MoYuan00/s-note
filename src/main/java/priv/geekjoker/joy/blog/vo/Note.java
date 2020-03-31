package priv.geekjoker.joy.blog.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.Objects;

@ToString
@Getter
@Setter
public class Note {
    private Long id;
    private Date createTime;
    private Date updateTime;

    private String title;
    private String content;
    private Boolean favorite;
    private Long userId;
    private Long clazzId;
    private String profile;

    private Boolean wasted;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note = (Note) o;
        return id.equals(note.id) &&
                createTime.equals(note.createTime) &&
                updateTime.equals(note.updateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createTime, updateTime);
    }
}
