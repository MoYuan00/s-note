package priv.geekjoker.joy.blog.service;

import priv.geekjoker.joy.blog.vo.Note;

public interface NoteInsert {
    /**
     * 插入一个新笔记
     * @param userId
     * @param note
     * @return
     */
    boolean noteInsert(Long userId, Note note);
}
