package cn.dianshi.controller;

import cn.dianshi.domain.Comment;
import cn.dianshi.domain.User;
import cn.dianshi.service.BlogService;
import cn.dianshi.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

/**
 * @author Dianshi
 */
@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private BlogService blogService;

    @Value("${comment.avatar}")
    private String avatar;

    @GetMapping(path = "/comments/{blogid}")
    public String getComments(@PathVariable Long blogid, Model model){
        model.addAttribute("comments",commentService.listCommentByBlogId(blogid));
        return "blog :: commentList";
    }

    @PostMapping(path = "/comments")
    public String postComment(Comment comment, HttpSession session){
        Long id = comment.getBlog().getId();
        comment.setBlog(blogService.getBlog(id));
        User user = (User) session.getAttribute("user");
        if (user != null){
            comment.setAvatar(user.getAvatar());
            comment.setAdminComment(true);
//            comment.setNickname(user.getNickname());
        } else {
            comment.setAvatar(avatar);
        }
        commentService.saveComment(comment);
        return "redirect:/comments/" + id;
    }
}
