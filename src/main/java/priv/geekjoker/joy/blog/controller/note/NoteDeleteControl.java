package priv.geekjoker.joy.blog.controller.note;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import priv.geekjoker.joy.blog.controller.utils.LoginUserUtils;
import priv.geekjoker.joy.blog.service.NoteDelete;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/note")
public class NoteDeleteControl {
    @Autowired
    NoteDelete noteDelete;

    @ResponseBody
    @RequestMapping("/delete")
    ModelMap delete(HttpSession session, Long id){
        Long userId = LoginUserUtils.getLoginUserId(session);
        boolean success = noteDelete.deleteNote(userId, id);
        ModelMap modelMap = new ModelMap();
        modelMap.addAttribute("state", success);
        return modelMap;
    }
}
