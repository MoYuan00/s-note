package priv.geekjoker.joy.blog.service;

/**
 * 检查密码是否复合要求
 */
public interface PasswordChecker {
    boolean check(String password);
}
