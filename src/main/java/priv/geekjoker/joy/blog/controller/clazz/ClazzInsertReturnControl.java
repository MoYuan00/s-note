package priv.geekjoker.joy.blog.controller.clazz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import priv.geekjoker.joy.blog.controller.utils.LoginUserUtils;
import priv.geekjoker.joy.blog.service.ClazzInsert;
import priv.geekjoker.joy.blog.vo.Clazz;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/clazz")
public class ClazzInsertReturnControl {

    @Autowired
    ClazzInsert clazzInsert;

    @ResponseBody
    @RequestMapping("/insertReturn")
    ModelMap insertReturn(HttpSession session, @RequestBody Clazz clazz){
        Long userId = LoginUserUtils.getLoginUserId(session);
        return new ModelMap("data", clazzInsert.insertClazzReturn(userId, clazz));
    }
}
