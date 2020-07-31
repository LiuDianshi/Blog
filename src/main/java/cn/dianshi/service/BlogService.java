package cn.dianshi.service;

import cn.dianshi.domain.Blog;
import cn.dianshi.exception.NotFoundException;
import cn.dianshi.vo.BlogQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BlogService {

    public abstract Blog getBlog(Long id);

    public abstract Page<Blog> listBlog(Pageable pageable, BlogQuery blog);

    public abstract Blog saveBlog(Blog blog);

    public abstract Blog updateBlog(Long id, Blog blog) throws NotFoundException;

    public abstract void deleteBlog(Long id);
}
