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
    UserSelectMapper userSelectMapper;
    private Log log = LogFactory.getLog(UserSelectImpl.class);
    @Override
    public List<User> listUser() {
        List<User> userList = userSelectMapper.listUser();
        if(userList != null)
            for(User user : userList){// 清理查询出来的密码 和 id 保密安全
                user.setPassword(null);
                user.setId(null);
            }
        log.debug("listUser() 所有的user个数: " + userList.size());
        return userList;
    }

    @Override
    public User checkUserNicknameWithPassword(String nickname, String password) {
        User user = userSelectMapper.selectUserByNickname(nickname);
        if(user != null && user.getPassword().equals(password)){
            return user;
        }
        return null;
    }

    @Override
    public User selectUserById(Long userId) {
        if(userId == null) return  null;
        User user = userSelectMapper.selectUserById(userId);
        // 保密 user id 和 密码
        user.setPassword("*********");
        user.setId(null);
        return user;
    }
}
