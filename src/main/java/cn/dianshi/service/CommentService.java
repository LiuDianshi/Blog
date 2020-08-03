package cn.dianshi.service;

import cn.dianshi.domain.Comment;

import java.util.List;

public interface CommentService {

    public abstract List<Comment> listCommentByBlogId(Long blogId);

    public abstract Comment saveComment(Comment comment);
}
