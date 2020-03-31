package priv.geekjoker.joy.blog.service;

import priv.geekjoker.joy.blog.vo.Note;

import java.util.List;

public interface NoteSelect {
    List<Note> listNote();

    /**
     * 获取 一个 用户 的 所有笔记 （不包括废弃笔记）
     * @param userId
     * @return
     */
    List<Note> listNoteByUserId(Long userId);

    /**
     * 获取一个用户 废弃 的 笔记列表
     * @param userId
     * @return
     */
    List<Note> listWastedNoteByUserId(Long userId);

    /**
     * 通过 用户 id 和 noteId 获取 笔记
     * @param userId
     * @param noteId
     * @return
     */
    Note selectNoteById(Long userId, Long noteId);

}
