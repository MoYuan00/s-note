package priv.geekjoker.joy.blog.controller.clazz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import priv.geekjoker.joy.blog.controller.utils.LoginUserUtils;
import priv.geekjoker.joy.blog.service.ClazzDelete;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/clazz")
public class ClazzDeleteControl {
    @Autowired
    ClazzDelete clazzDelete;

    @RequestMapping("/delete")
    @ResponseBody
    ModelMap delete(HttpSession session, Long clazzId){
        Long userId = LoginUserUtils.getLoginUserId(session);
        boolean success = clazzDelete.deleteClazzById(clazzId, userId);
        return new ModelMap("state", success);
    }
}
