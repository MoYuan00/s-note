package priv.geekjoker.joy.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.geekjoker.joy.blog.mapper.NoteInsertMapper;
import priv.geekjoker.joy.blog.service.NoteInsert;
import priv.geekjoker.joy.blog.vo.Note;

import java.util.Date;

@Service
public class NoteInsertImpl implements NoteInsert {
    @Autowired
    NoteInsertMapper noteInsertMapper;
    @Override
    public boolean noteInsert(Long userId, Note note) {
        if(userId == null) return false;
        note.setCreateTime(new Date());
        note.setUpdateTime(new Date());
        note.setUserId(userId);
        return noteInsertMapper.noteInsert(note);
    }
}
