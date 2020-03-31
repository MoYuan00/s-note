package priv.geekjoker.joy.blog.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import priv.geekjoker.joy.blog.service.PasswordChecker;

/**
 * 检查用户密码
 */
@Service
public class UserPasswordChecker implements PasswordChecker {
    public static final int PASSWORD_MIN_LEN = 6;
    public static final int PASSWORD_MAX_LEN = 6;
    Log log = LogFactory.getLog(UserPasswordChecker.class);
    @Override
    public boolean check(String password) {
        if(password == null) {
            log.debug("密码为 null");
            return false;
        }
        int len = password.trim().length();
        if(len <= PASSWORD_MAX_LEN && len >= PASSWORD_MIN_LEN) return true;
        log.debug("密码长度不合格");
        return false;
    }
}
