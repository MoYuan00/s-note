package priv.geekjoker.joy.blog.controller.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

public class LoginUserUtils {
    /**
     * 保存 userId 到 session 中
     * @param session
     * @return
     */
    public static void saveLoginUserId(HttpSession session, Long userId){
        session.setAttribute(Strings.LOGIN_USER_ID, userId);
    }

    /**
     * 获取session 中 的 userId
     * @param session
     * @return
     */
    public static Long getLoginUserId(HttpSession session){
        Long userId = (Long) session.getAttribute(Strings.LOGIN_USER_ID);
        if(userId == null){
            if(OwnConfig.debug){
                userId = OwnConfig.debugUserId;
            }
        }
        return userId;
    }

    /**
     * 删除 session 中 的 userid
     * @param session
     */
    public static void clearLoginUserId(HttpSession session){
        session.removeAttribute(Strings.LOGIN_USER_ID);
    }
}
