package priv.geekjoker.joy.blog.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * 笔记 分类
 */
@Setter
@ToString
@Getter
public class Clazz {
    private Long id;
    private Date createTime;
    private Date updateTime;

    private String title;
    private String detail;
    private Long userId;
}
