package priv.geekjoker.joy.blog.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import priv.geekjoker.joy.blog.mapper.ClazzSelectMapper;
import priv.geekjoker.joy.blog.mapper.NoteSelectMapper;
import priv.geekjoker.joy.blog.mapper.NoteUpdateMapper;
import priv.geekjoker.joy.blog.service.NoteUpdate;
import priv.geekjoker.joy.blog.vo.Clazz;
import priv.geekjoker.joy.blog.vo.Note;

import java.util.Date;

@Service
public class NoteUpdateImpl implements NoteUpdate {
    @Autowired
    NoteUpdateMapper noteUpdateMapper;

    @Autowired
    NoteSelectMapper noteSelectMapper;
    @Autowired
    ClazzSelectMapper clazzSelectMapper;

    Log log = LogFactory.getLog(NoteUpdateImpl.class);

    @Override
    public boolean updateNote(Note note, Long userId) {
        log.debug("更新: " + "note: " + note + " userId:" + userId);
        if(note == null || userId == null) return false;
        note.setUpdateTime(new Date());
        return noteUpdateMapper.noteUpdate(note);
    }

    @Transactional
    @Override
    public boolean recoveryNote(Long noteId, Long userId) {
        if(noteId == null || userId == null) return false;
        Note note = noteSelectMapper.selectNoteById(noteId);
        // 查找 被 删除 的 分类 是否 还 存在
        // 如果 分类已经不存在
        if(!clazzSelectMapper.listClazzByUserId(userId)
                .stream().findFirst().filter(c -> c.getId().equals(note.getClazzId()))
                .isPresent()
        )
            note.setClazzId(null);// 就 设置 为 默认分类
        note.setWasted(false);
        return noteUpdateMapper.noteUpdate(note);
    }
}
