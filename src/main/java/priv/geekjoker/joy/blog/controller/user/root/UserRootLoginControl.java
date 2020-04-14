package priv.geekjoker.joy.blog.controller.user.root;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import priv.geekjoker.joy.blog.controller.utils.LoginUserUtils;
import priv.geekjoker.joy.blog.service.UserSelect;

@Controller
@RequestMapping("/user/root")
public class UserRootLoginControl {
    @Autowired
    UserSelect userSelect;
    Log log = LogFactory.getLog(UserRootLoginControl.class);

    @RequestMapping("/isLogin")
    @ResponseBody
    ModelMap isLogin(HttpSession session) {
        Long userId = LoginUserUtils.getLoginUserId(session);
        log.debug("/user/root/isLogin 尝试验证管理员权限: userId=" + userId);
        boolean result = userSelect.checkUserIdRootById(userId);
        return new ModelMap("state", result);
    }
}