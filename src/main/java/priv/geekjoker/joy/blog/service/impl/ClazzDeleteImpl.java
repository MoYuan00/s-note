package priv.geekjoker.joy.blog.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import priv.geekjoker.joy.blog.mapper.ClazzDeleteMapper;
import priv.geekjoker.joy.blog.service.ClazzDelete;
import priv.geekjoker.joy.blog.service.NoteDelete;
import priv.geekjoker.joy.blog.service.NoteSelect;
import priv.geekjoker.joy.blog.vo.Note;

import java.util.List;

@Service
public class ClazzDeleteImpl implements ClazzDelete {
    @Autowired
    ClazzDeleteMapper clazzDeleteMapper;

    @Autowired
    NoteDelete noteDelete;

    @Autowired
    NoteSelect noteSelect;

    Log log = LogFactory.getLog(ClazzDeleteImpl.class);

    @Transactional
    @Override
    public boolean deleteClazzById(Long clazzId, Long userId) {
        if(clazzId == null || userId == null) return false;
        int count = noteDelete.deleteNoteByClazzId(userId, clazzId);
        log.debug("删除clazz类型: " + " 删除笔记条数: " + count);
        return clazzDeleteMapper.classDeleteById(clazzId);
    }
}
