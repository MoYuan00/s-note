package priv.geekjoker.joy.blog.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.geekjoker.joy.blog.mapper.NoteSelectMapper;
import priv.geekjoker.joy.blog.service.NoteSelect;
import priv.geekjoker.joy.blog.vo.Note;

import java.util.List;

@Service
public class NoteSelectImpl implements NoteSelect {

    private Log log = LogFactory.getLog(NoteSelectImpl.class);

    @Autowired
    NoteSelectMapper noteSelectMapper;

    @Override
    public List<Note> listNote() {
        List<Note> noteList = noteSelectMapper.listNote();
        log.debug("NoteSelectImpl.listNote() 获取的笔记个数: " + noteList.size());
        return noteList;
    }

    @Override
    public List<Note> listNoteByUserId(Long userId) {
        if(userId == null) return null;
        List<Note> noteList = noteSelectMapper.listNoteByUserId(userId);
        // 过滤 已经废弃的
        noteList.removeIf(note -> note.getWasted() == null || note.getWasted());
        log.debug("NoteSelectImpl.listNoteByUserId() 获取的笔记个数: " + noteList.size());
        return noteList;
    }

    @Override
    public List<Note> listWastedNoteByUserId(Long userId) {
        if(userId == null) return null;
        List<Note> noteList = noteSelectMapper.listNoteByUserId(userId);
        // 过滤 没有废弃的
        noteList.removeIf(note -> !note.getWasted());
        log.debug("NoteSelectImpl.listWastedNoteByUserId() 获取的笔记个数: " + noteList.size());
        return noteList;
    }

    @Override
    public Note selectNoteById(Long userId, Long noteId) {
        if(userId == null || noteId == null) return null;
        return noteSelectMapper.selectNoteByIdAndUserId(noteId, userId);
    }
}
