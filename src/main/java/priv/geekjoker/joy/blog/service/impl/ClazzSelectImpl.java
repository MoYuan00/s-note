package priv.geekjoker.joy.blog.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.geekjoker.joy.blog.mapper.ClazzSelectMapper;
import priv.geekjoker.joy.blog.service.ClazzSelect;
import priv.geekjoker.joy.blog.vo.Clazz;

import java.util.List;

@Service
public class ClazzSelectImpl implements ClazzSelect {

    @Autowired
    ClazzSelectMapper clazzSelectMapper;

    Log log = LogFactory.getLog(ClazzSelectImpl.class);

    @Override
    public List<Clazz> listClazzByUserId(Long userId) {
        if(userId == null) return null;
        List<Clazz> clazzList = clazzSelectMapper.listClazzByUserId(userId);
        log.debug(String.format("listClazzByUserId() 查询的用户id=%d, 返回数量为=%d", userId, clazzList.size()));
        return clazzList;
    }
}
