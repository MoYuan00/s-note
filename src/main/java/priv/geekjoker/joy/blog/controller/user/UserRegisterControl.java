package priv.geekjoker.joy.blog.controller.user;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import priv.geekjoker.joy.blog.dto.UserRegisterDTO;
import priv.geekjoker.joy.blog.service.UserRegister;
import priv.geekjoker.joy.blog.vo.User;

@Controller
@RequestMapping("/user")
public class UserRegisterControl {
    @Autowired
    UserRegister userRegister;

    Log log = LogFactory.getLog(UserRegisterControl.class);

    @ResponseBody
    @RequestMapping("/register")
    ModelMap insert(@RequestBody UserRegisterDTO userRegisterDTO){
        log.debug("/register 注册请求为: " + userRegisterDTO);
        boolean success = userRegister.userRegister(userRegisterDTO.getNickname(),
                userRegisterDTO.getPassword());
        ModelMap modelMap = new ModelMap();
        modelMap.addAttribute("state", success);
        return modelMap;
    }
}
