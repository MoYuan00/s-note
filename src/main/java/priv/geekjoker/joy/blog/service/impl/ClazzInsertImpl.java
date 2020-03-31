package priv.geekjoker.joy.blog.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.geekjoker.joy.blog.mapper.ClazzInsertMapper;
import priv.geekjoker.joy.blog.service.ClazzInsert;
import priv.geekjoker.joy.blog.vo.Clazz;

import java.util.Date;

@Service
public class ClazzInsertImpl implements ClazzInsert {
    @Autowired
    ClazzInsertMapper clazzInsertMapper;

    Log log = LogFactory.getLog(ClazzInsertImpl.class);

    @Override
    public Clazz insertClazzReturn(Long userId, Clazz clazz) {
        log.debug("insertClazzReturn：" + " userId:" + userId + " clazz:" + clazz);
        if(userId == null || clazz == null) return null;
        clazz.setUserId(userId);
        clazz.setCreateTime(new Date());
        clazz.setUpdateTime(new Date());
        boolean success = clazzInsertMapper.clazzInsert(clazz);
        if(success)
            return clazz;
        return null;
    }
}
