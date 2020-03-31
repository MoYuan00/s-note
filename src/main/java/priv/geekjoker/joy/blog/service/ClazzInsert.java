package priv.geekjoker.joy.blog.service;

import priv.geekjoker.joy.blog.vo.Clazz;

public interface ClazzInsert {
    Clazz insertClazzReturn(Long userId, Clazz clazz);
}
