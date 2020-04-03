package priv.geekjoker.joy.blog.service;

import priv.geekjoker.joy.blog.vo.User;

import java.util.List;

public interface UserSelect {
    List<User> listUser();

    /**
     * root权限  查询出所有用户的所有信息，
     * @param userRootId 管理员用户id
     * @return
     */
    List<User> listUserUseRoot(Long userRootId);

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

    /**
     * 管理员登陆
     * @return 返回登陆成功的用户，登陆失败返回null
     */
    User loginByRoot(String nickname, String password);
    /**
     * 通过 id 判断 用户是不是管理员
     * @param userId
     * @return
     */
    boolean checkUserIdRootById(Long userId);
}
