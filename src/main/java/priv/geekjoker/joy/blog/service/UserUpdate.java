package priv.geekjoker.joy.blog.service;

import priv.geekjoker.joy.blog.vo.User;

public interface UserUpdate {
    /**
     * 修改用户的 密码
     * @param password 密码
     * @param userId 用户id
     * @return
     */
    boolean userUpdatePassword(String password, Long userId);
}
