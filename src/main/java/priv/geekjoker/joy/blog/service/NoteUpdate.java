package priv.geekjoker.joy.blog.service;

import priv.geekjoker.joy.blog.vo.Note;

public interface NoteUpdate {
    /**
     * 更新 一条笔记
     * @param note
     * @return
     */
    boolean updateNote(Note note, Long userId);

    /**
     * 从垃圾箱 恢复 一条笔记
     * @param noteId
     * @param userId
     * @return
     */
    boolean recoveryNote(Long noteId, Long userId);
}
