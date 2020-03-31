package priv.geekjoker.joy.blog.service;

import priv.geekjoker.joy.blog.vo.User;

import java.util.List;

public interface UserSelect {
    List<User> listUser();

    /**
     * 判断用户的 nickname 和 password 是否匹配
     * @return
     */
    User checkUserNicknameWithPassword(String nickname, String password);

    /**
     * 通过一个用户的id 获取 用户信息
     * @param userId
     * @return
     */
    User selectUserById(Long userId);
}
