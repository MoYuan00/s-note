package priv.geekjoker.joy.blog.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.geekjoker.joy.blog.mapper.UserInsertMapper;
import priv.geekjoker.joy.blog.service.UserRegister;
import priv.geekjoker.joy.blog.vo.User;

import java.util.Date;

@Service
public class UserRegisterImpl implements UserRegister {
    @Autowired
    UserInsertMapper userInsertMapper;
    Log log = LogFactory.getLog(UserRegisterImpl.class);
    @Override
    public boolean userRegister(String nickname, String password) {
        // 控制名称长度 和 非空
        if(nickname == null
                || nickname.length() < 4
                || nickname.length() > 15){
            return false;
        }
        // 控制密码长度 和 非空
        if(password == null
                || password.length() < 6
                || password.length() > 30){
            return false;
        }
        User user = new User();
        user.setNickname(nickname);
        user.setPassword(password);
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        boolean success = userInsertMapper.userInsert(user);
        log.debug("注册结果: " + user);
        return success;

    }
}
