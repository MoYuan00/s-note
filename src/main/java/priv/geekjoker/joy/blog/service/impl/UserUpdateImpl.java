package priv.geekjoker.joy.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.geekjoker.joy.blog.mapper.UserUpdateMapper;
import priv.geekjoker.joy.blog.service.UserUpdate;
import priv.geekjoker.joy.blog.vo.User;

import java.util.Date;

@Service
public class UserUpdateImpl implements UserUpdate {
    @Autowired
    UserUpdateMapper userUpdateMapper;
    @Autowired
    UserPasswordChecker userPasswordChecker;

    @Override
    public boolean userUpdatePassword(String password, Long userId) {
        if(userId == null) return false;
        if(!userPasswordChecker.check(password)) return false;
        User user = new User();
        user.setId(userId);
        user.setUpdateTime(new Date());
        user.setPassword(password.trim());
        return userUpdateMapper.userUpdatePassWord(user);
    }
}
