package priv.geekjoker.joy.blog.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
  */
@ToString
@Setter
@Getter
public class NoteOperate {
    /**
     * 操作数 对应 的意义
     */
    // const operate = {insert: 1, delete: -2, update: -1};
    public static final int INSERT = 1;
    public static final int DELETE = -2;
    public static final int UPDATE = -1;

    private Integer operateType;
    private Long id;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NoteOperate that = (NoteOperate) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
