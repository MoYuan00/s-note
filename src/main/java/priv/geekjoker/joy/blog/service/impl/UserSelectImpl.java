package priv.geekjoker.joy.blog.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.geekjoker.joy.blog.mapper.UserSelectMapper;
import priv.geekjoker.joy.blog.service.UserSelect;
import priv.geekjoker.joy.blog.vo.User;

import java.util.List;

@Service
public class UserSelectImpl implements UserSelect {
    @Autowired
    UserSelect userSelect;

    @Autowired
    UserSelectMapper userSelectMapper;
    private Log log = LogFactory.getLog(UserSelectImpl.class);

    @Override
    public List<User> listUser() {
        List<User> userList = userSelectMapper.listUser();
        if (userList != null)
            for (User user : userList) {// 清理查询出来的密码 和 id 保密安全
                user.setPassword(null);
                user.setId(null);
            }
        log.debug("listUser() 所有的user个数: " + userList.size());
        return userList;
    }

    @Override
    public User checkUserNicknameWithPassword(String nickname, String password) {
        User user = userSelectMapper.selectUserByNickname(nickname);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    @Override
    public User selectUserById(Long userId) {
        if (userId == null)
            return null;
        User user = userSelectMapper.selectUserById(userId);
        // 保密 user id 和 密码
        user.setPassword("*********");
        user.setId(null);
        return user;
    }

    @Override
    public User loginByRoot(String nickname, String password) {
        if (nickname == null || password == null)
            return null;
        log.debug("loginByRoot: nickname:" + nickname);
        User user = userSelectMapper.selectUserByNickname(nickname);
        if (user != null && user.getPassword().equals(password) && user.getRole() != null && user.getRole()) {
            user.setPassword("********");// 隐藏密码
            user.setRole(null);
            return user;
        }
        return null;
    }

    @Override
    public List<User> listUserUseRoot(Long userId) {
        log.debug("listUserUseRoot() userId: " + userId);
        if(userId == null) return null;
        if(!userSelect.checkUserIdRootById(userId)){// 检查是否是管理员
            log.debug("listUserUseRoot() 当前登陆不是管理员，获取用户失败！");
            return null;
        }
        List<User> userList = userSelectMapper.listUser();
        log.debug("listUserByRoot() 所有的user个数: " + userList.size());
        return userList;
    }

    @Override
    public boolean checkUserIdRootById(Long userId) {
        if(userId == null) return false;
        User user = userSelectMapper.selectUserById(userId);
        log.debug("checkUserIdRootById() 判断用户是否是管理员: " + user);
        if(user == null) return false;// 没有此用户
        if(user.getRole() == null) return false; 
        if(user.getRole()) return true;// 是管理员
        return false;
    }
}
