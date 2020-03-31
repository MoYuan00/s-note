package priv.geekjoker.joy.blog.service;

import priv.geekjoker.joy.blog.dto.NoteOperate;
import priv.geekjoker.joy.blog.vo.Note;

import java.util.List;

public interface NoteListSave {
    /**
     * 保存笔记
     * @param userId 登录的用户 id
     * @param noteList 提交的笔记列表
     * @param noteOperateList 要执行的操作 由操作,id构成
     * @return
     */
    boolean saveNoteList(Long userId,List<Note> noteList, List<NoteOperate> noteOperateList);
}
