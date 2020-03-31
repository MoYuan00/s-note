package priv.geekjoker.joy.blog.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import priv.geekjoker.joy.blog.controller.utils.LoginUserUtils;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserLogoutControl {

    @ResponseBody
    @RequestMapping("/logout")
    ModelMap logout(HttpSession session){
        LoginUserUtils.clearLoginUserId(session);
        return new ModelMap("data", true);
    }

}
