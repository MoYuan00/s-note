package priv.geekjoker.joy.blog.controller.note;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import priv.geekjoker.joy.blog.controller.utils.LoginUserUtils;
import priv.geekjoker.joy.blog.service.NoteUpdate;
import priv.geekjoker.joy.blog.vo.Note;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/note")
public class NoteUpdateControl {
    @Autowired
    NoteUpdate noteUpdate;

    @RequestMapping("/update")
    @ResponseBody
    ModelMap update(HttpSession session, @RequestBody Note note){
        Long userId = LoginUserUtils.getLoginUserId(session);
        boolean success = noteUpdate.updateNote(note, userId);
        return new ModelMap("state", success);
    }

    /**
     * 从垃圾箱恢复一个 笔记
     * @param session
     * @param id
     * @return
     */
    @RequestMapping("/recovery")
    @ResponseBody
    ModelMap recovery(HttpSession session, Long id){
        Long userId = LoginUserUtils.getLoginUserId(session);
        boolean success = noteUpdate.recoveryNote(id, userId);
        return new ModelMap("state", success);
    }
}
