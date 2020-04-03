package priv.geekjoker.joy.blog.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import priv.geekjoker.joy.blog.controller.utils.LoginUserUtils;
import priv.geekjoker.joy.blog.service.UserSelect;
import priv.geekjoker.joy.blog.vo.User;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserSelectControl {

    @Autowired
    UserSelect userSelect;

    @RequestMapping("/select")
    @ResponseBody
    public ModelMap select(){
        ModelMap modelMap = new ModelMap();
        modelMap.addAttribute("data", userSelect.listUser());
        return modelMap;
    }

    /**
     * 管理员权限
     * 查询出所有用户所有的信息
     */
    @RequestMapping("/selectUseRoot")
    @ResponseBody
    public ModelMap selectUseRoot(HttpSession session){
        Long userId = LoginUserUtils.getLoginUserId(session);
        ModelMap modelMap = new ModelMap();
        modelMap.addAttribute("data", userSelect.listUserUseRoot(userId));
        return modelMap;
    }

    /**
     * 获取当前登陆 用户 的 id
     * 如果session 中 有用户id 表明登陆了，如果没有表示没有登陆
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping("/getLoginUser")
    ModelMap getLoginUser(HttpSession session){
        ModelMap modelMap = new ModelMap();
        Long userId = LoginUserUtils.getLoginUserId(session);
        User user =  userSelect.selectUserById(userId);
        return modelMap.addAttribute("data", user);
    }

    

}
