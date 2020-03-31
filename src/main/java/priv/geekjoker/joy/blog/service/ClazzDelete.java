package priv.geekjoker.joy.blog.service;

public interface ClazzDelete {
    /**
     * 通过 类型 id 删除 类型
     * @param clazzId
     * @param userId
     * @return
     */
    boolean deleteClazzById(Long clazzId, Long userId);
}
