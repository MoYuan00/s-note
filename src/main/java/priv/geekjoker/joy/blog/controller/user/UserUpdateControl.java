package priv.geekjoker.joy.blog.controller.user;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import priv.geekjoker.joy.blog.controller.utils.LoginUserUtils;
import priv.geekjoker.joy.blog.service.UserUpdate;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserUpdateControl {
    @Autowired
    UserUpdate userUpdate;
    Log log = LogFactory.getLog(UserUpdateControl.class);

    @ResponseBody
    @RequestMapping("/updatePassword")
    ModelMap updatePassword(String password, HttpSession httpSession){
        log.debug("updatePassword: " + password);
        Long userId = LoginUserUtils.getLoginUserId(httpSession);
        return new ModelMap("state",
                userUpdate.userUpdatePassword(password, userId));
    }

}
