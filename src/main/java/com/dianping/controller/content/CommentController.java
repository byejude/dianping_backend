package com.dianping.controller.content;

import com.dianping.dto.CommentDto;
import com.dianping.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by byebyejude on 2017/10/8.
 */

@Controller
@RequestMapping("/comments")
public class CommentController {

@Autowired
private CommentService commentService;

    @RequestMapping
    public String init(Model model, CommentDto commentDto) {

        model.addAttribute("list",commentService.selectByPage(commentDto));
        model.addAttribute("searchParam", commentDto);
        return "/content/commentList";
    }

    @RequestMapping("/search")
    public String search(Model model,CommentDto commentDto){
        model.addAttribute("list",commentService.selectByLikeComment(commentDto));
        model.addAttribute("searchParam", commentDto);
        return "/content/commentList";
    }

}
