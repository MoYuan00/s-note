package priv.geekjoker.joy.blog.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.geekjoker.joy.blog.mapper.ClazzUpdateMapper;
import priv.geekjoker.joy.blog.service.ClazzUpdate;
import priv.geekjoker.joy.blog.vo.Clazz;

import java.util.Date;

@Service
public class ClazzUpdateImpl implements ClazzUpdate {
    @Autowired
    ClazzUpdateMapper clazzUpdateMapper;

    Log log = LogFactory.getLog(ClazzUpdateImpl.class);

    @Override
    public boolean updateClazz(Long userId, Clazz clazz) {
        log.debug("updateClazz: userId:" + userId + " clazz:" + clazz);
        if(userId == null || clazz == null) return false;
        clazz.setUpdateTime(new Date());
        return clazzUpdateMapper.clazzUpdate(clazz);
    }
}
