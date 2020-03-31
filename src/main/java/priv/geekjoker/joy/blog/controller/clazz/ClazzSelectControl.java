package priv.geekjoker.joy.blog.controller.clazz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import priv.geekjoker.joy.blog.controller.utils.LoginUserUtils;
import priv.geekjoker.joy.blog.service.ClazzSelect;
import priv.geekjoker.joy.blog.vo.Clazz;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/clazz")
public class ClazzSelectControl {

    @Autowired
    ClazzSelect clazzSelect;

    @ResponseBody
    @RequestMapping("/select")
    ModelMap select(HttpSession session){
        Long userId = LoginUserUtils.getLoginUserId(session);
        List<Clazz> clazzList = clazzSelect.listClazzByUserId(userId);
        ModelMap modelMap = new ModelMap();
        modelMap.addAttribute("data", clazzList);
        return modelMap;
    }
}
