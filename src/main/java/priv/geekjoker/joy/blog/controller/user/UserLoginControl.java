package priv.geekjoker.joy.blog.controller.user;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import priv.geekjoker.joy.blog.controller.utils.LoginUserUtils;
import priv.geekjoker.joy.blog.controller.utils.Strings;
import priv.geekjoker.joy.blog.dto.UserLogin;
import priv.geekjoker.joy.blog.service.UserSelect;
import priv.geekjoker.joy.blog.vo.User;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserLoginControl {
    @Autowired
    UserSelect userSelect;

    Log log = LogFactory.getLog(UserLoginControl.class);

    /**
     * 登录，并储存 userId
     * @param userLogin
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping("/login")
    ModelMap login(@RequestBody UserLogin userLogin, HttpSession session){
        log.debug("/login 登陆请求: " + userLogin);
        User user = userSelect.checkUserNicknameWithPassword(userLogin.getNickname(), userLogin.getPassword());
        if(user != null){// 如果登陆成功
            // 加入session
            LoginUserUtils.saveLoginUserId(session, user.getId());
            return new ModelMap("state", true);
        }
        return new ModelMap("state", false);
    }

     /**
     * 登录管理员账户，并储存 userId
     * @param userLogin 
     * @param session 
     * @return
     */
    @ResponseBody
    @RequestMapping("/loginByRoot")
    ModelMap loginByRoot(@RequestBody UserLogin user, HttpSession session){
        log.debug("/loginByRoot 登陆请求: " + user);
        User resultUser = userSelect.loginByRoot(
            user.getNickname(), 
            user.getPassword());
        if(resultUser != null){// 如果登陆成功
            // 加入 session
            LoginUserUtils.saveLoginUserId(session, resultUser.getId());
            return new ModelMap("state", true);
        }
        return new ModelMap("state", false);
    }

    /**
     * 获取当前登陆 用户 的 id
     * 如果session 中 有用户id 表明登陆了，如果没有表示没有登陆
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping("/getLoginUserId")
    ModelMap getLoginUserId(HttpSession session){
        ModelMap modelMap = new ModelMap();
        Long userId = LoginUserUtils.getLoginUserId(session);
        return modelMap.addAttribute("data", userId);
    }



}
