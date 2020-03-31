package priv.geekjoker.joy.blog.controller.note;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import priv.geekjoker.joy.blog.controller.utils.LoginUserUtils;
import priv.geekjoker.joy.blog.service.NoteSelect;
import priv.geekjoker.joy.blog.vo.Note;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/note")
public class NoteSelectControl {

    @Autowired
    public NoteSelect noteSelect;

    Log log = LogFactory.getLog(NoteSelectControl.class);

    /**
     * 获取 笔记 （不包括废弃的）
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping("/get")
    public ModelMap select(final HttpSession session){
        final ModelMap md = new ModelMap();
        final Long userId = LoginUserUtils.getLoginUserId(session);
        final List<Note> noteList = noteSelect.listNoteByUserId(userId);
        md.addAttribute("data", noteList);
        return md;
    }

    /**
     * 获取废弃 的 笔记
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping("/getWasted")
    public ModelMap selectWasted(final HttpSession session){
        final ModelMap md = new ModelMap();
        final Long userId = LoginUserUtils.getLoginUserId(session);
        final List<Note> noteList = noteSelect.listWastedNoteByUserId(userId);
        md.addAttribute("data", noteList);
        return md;
    }

     /**
     * 获取的笔记
     * @return
     */
    @ResponseBody
    @RequestMapping("/getEditNote")
    ModelMap getEditNote(Long noteId, HttpSession session){
        final Long userId = LoginUserUtils.getLoginUserId(session);
        return  new ModelMap("data", noteSelect.selectNoteById(userId, noteId));
    }

    /**
     * 获取的笔记
     * @return
     */
    @ResponseBody
    @RequestMapping("/getAllUserNotes")
    ModelMap getAllUserNotes(){
        return  new ModelMap("data", noteSelect.listNote());
    }



}
