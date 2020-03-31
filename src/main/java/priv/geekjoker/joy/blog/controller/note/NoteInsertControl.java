package priv.geekjoker.joy.blog.controller.note;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import priv.geekjoker.joy.blog.controller.utils.LoginUserUtils;
import priv.geekjoker.joy.blog.service.NoteInsert;
import priv.geekjoker.joy.blog.vo.Note;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/note")
public class NoteInsertControl {
    @Autowired
    NoteInsert noteInsert;
    Log log = LogFactory.getLog(NoteInsertControl.class);

    @ResponseBody
    @RequestMapping("/insert")
    ModelMap insert(HttpSession session, @RequestBody Note note){
        log.debug("/note/insert note:" + note);
        ModelMap modelMap = new ModelMap();
        Long userId = LoginUserUtils.getLoginUserId(session);
        boolean success = noteInsert.noteInsert(userId, note);
        modelMap.addAttribute("state", success);
        return modelMap;
    }
}
