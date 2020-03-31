package priv.geekjoker.joy.blog.service;

import priv.geekjoker.joy.blog.vo.Clazz;

public interface ClazzUpdate {
    /**
     * 更新 类型
     * @param clazz
     * @param userId
     * @return
     */
    boolean updateClazz(Long userId, Clazz clazz);
}
