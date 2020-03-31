package priv.geekjoker.joy.blog.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.geekjoker.joy.blog.dto.NoteOperate;
import priv.geekjoker.joy.blog.mapper.NoteDeleteMapper;
import priv.geekjoker.joy.blog.mapper.NoteInsertMapper;
import priv.geekjoker.joy.blog.mapper.NoteSelectMapper;
import priv.geekjoker.joy.blog.mapper.NoteUpdateMapper;
import priv.geekjoker.joy.blog.service.NoteListSave;
import priv.geekjoker.joy.blog.vo.Note;

import java.util.List;
import java.util.Set;

import static priv.geekjoker.joy.blog.dto.NoteOperate.*;

@Service
public class NoteListSaveImpl implements NoteListSave {
    Log log = LogFactory.getLog(NoteListSaveImpl.class);
    @Autowired
    NoteSelectMapper noteSelectMapper;

    @Autowired
    NoteInsertMapper noteInsertMapper;

    @Autowired
    NoteUpdateMapper noteUpdateMapper;

    @Autowired
    NoteDeleteMapper noteDeleteMapper;

    @Override
    public boolean saveNoteList(Long userId, List<Note> noteList, List<NoteOperate> noteOperateList) {
        if(noteList == null) return false;
        if(userId == null) return false;
        int insertCount = 0;
        int updateCount = 0;
        int deleteCount = 0;
        for (NoteOperate operate: noteOperateList) {
            Note note = noteList.stream()
                    .filter(note1 -> note1.getId().equals(operate.getId()))
                    .findFirst().get();
            if(note != null){
                switch (operate.getOperateType()){
                    case INSERT:
                        note.setUserId(userId);
                        noteInsertMapper.noteInsert(note);
                        insertCount++;
                        break;
                    case UPDATE:
                        noteUpdateMapper.noteUpdate(note);
                        updateCount++;
                        break;
                    case DELETE:
                        noteDeleteMapper.deleteNoteById(note.getId());
                        deleteCount++;
                        break;
                }
            }
        }
        log.debug(String.format("插入note数%d, 更新note数:%d, 删除note数: %d",
                insertCount,  updateCount, deleteCount));
        return true;
    }
}
