package priv.geekjoker.joy.blog.controller.note;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import priv.geekjoker.joy.blog.controller.utils.LoginUserUtils;
import priv.geekjoker.joy.blog.dto.ListNote;
import priv.geekjoker.joy.blog.service.NoteListSave;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/note")
public class SaveNoteListControl {
    static Log log = LogFactory.getLog(SaveNoteListControl.class);
    @Autowired
    NoteListSave noteListSave;

    @RequestMapping("/save")
    @ResponseBody
    public ModelMap save(@RequestBody ListNote noteList, HttpSession session){
        log.debug("提交的noteList:" + noteList);
        ModelMap modelMap = new ModelMap();
        Long userId = LoginUserUtils.getLoginUserId(session);
        boolean state = noteListSave.saveNoteList(userId, noteList.getNoteList(), noteList.getNoteOperateList());
        modelMap.addAttribute("data", state);
        return modelMap;
    }
}
