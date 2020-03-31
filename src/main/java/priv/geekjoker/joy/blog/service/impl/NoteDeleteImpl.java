package priv.geekjoker.joy.blog.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.geekjoker.joy.blog.mapper.NoteDeleteMapper;
import priv.geekjoker.joy.blog.mapper.NoteSelectMapper;
import priv.geekjoker.joy.blog.mapper.NoteUpdateMapper;
import priv.geekjoker.joy.blog.service.NoteDelete;
import priv.geekjoker.joy.blog.vo.Note;

@Service
public class NoteDeleteImpl implements NoteDelete {
    @Autowired
    NoteDeleteMapper noteDeleteMapper;

    @Autowired
    NoteUpdateMapper noteUpdateMapper;

    @Autowired
    NoteSelectMapper noteSelectMapper;

    Log log = LogFactory.getLog(NoteDeleteImpl.class);

    @Override
    public boolean deleteNote(Long userId, Long noteId) {
        log.debug("userId:" + userId + "  noteId:" + noteId);
        if(userId == null || noteId == null) return false;
        Note note = noteSelectMapper.selectNoteByIdAndUserId(noteId, userId);
        // 如果要删除的 笔记 是当前登陆用户的，就删除
        if(note != null){
            boolean success = false;
            // 如果已经废弃 就 彻底删除
            if(note.getWasted()) {
                success = noteDeleteMapper.deleteNoteById(noteId);
                log.debug("删除结果: " + success);
            }else{
                // 将笔记标记为 废弃 waste
                note.setWasted(true);
                success = noteUpdateMapper.noteUpdate(note);
            }
            return success;
        }
        return false;
    }

    @Override
    public int deleteNoteByClazzId(Long userId, Long clazzId) {
        if(userId == null || clazzId == null) return 0;
        return noteDeleteMapper.deleteNoteByClazzId(clazzId);
    }
}
