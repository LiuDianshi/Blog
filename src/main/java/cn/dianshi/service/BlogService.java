package cn.dianshi.service;

import cn.dianshi.domain.Blog;
import cn.dianshi.exception.NotFoundException;
import cn.dianshi.vo.BlogQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface BlogService {

    public abstract Blog getBlog(Long id);

    public abstract Blog getAndConvertBlog(Long id) throws NotFoundException;

    public abstract Page<Blog> listBlog(Pageable pageable, BlogQuery blog);

    public abstract Page<Blog> listBlog(Long tagId,Pageable pageable);

    public abstract Page<Blog> listBlog(Pageable pageable);

    public abstract Page<Blog> listBlog(String query, Pageable pageable);

    public abstract List<Blog> listRecommendBlogTop(Integer size);

    public abstract Map<String,List<Blog>> archiveBlog();

    public abstract Long countBlog();

    public abstract Blog saveBlog(Blog blog);

    public abstract Blog updateBlog(Long id, Blog blog) throws NotFoundException;

    public abstract void deleteBlog(Long id);
}
