package priv.geekjoker.joy.blog.service;

public interface NoteDelete {
    /**
     * 删除一个笔记
     * @param userId
     * @param noteId
     * @return
     */
    boolean deleteNote(Long userId, Long noteId);

    /**
     * 通过 clazz id 删除 很多 笔记
     * @param userId
     * @param clazzId
     * @return
     */
    int deleteNoteByClazzId(Long userId, Long clazzId);
}
