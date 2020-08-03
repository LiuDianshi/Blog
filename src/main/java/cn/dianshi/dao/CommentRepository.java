package cn.dianshi.dao;

import cn.dianshi.domain.Comment;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Dianshi
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {
    public abstract List<Comment> findByBlogId(Long blogId, Sort sort);

    public abstract List<Comment> findByBlogIdAndParentCommentNull(Long blogId, Sort sort);
}
