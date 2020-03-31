package priv.geekjoker.joy.blog.service;


import priv.geekjoker.joy.blog.vo.Clazz;

import java.util.List;

public interface ClazzSelect {
    List<Clazz> listClazzByUserId(Long userId);
}
