package cn.dianshi.service.Impl;

import cn.dianshi.dao.BlogRepository;
import cn.dianshi.domain.Blog;
import cn.dianshi.domain.Type;
import cn.dianshi.exception.NotFoundException;
import cn.dianshi.service.BlogService;
import cn.dianshi.util.MyBeanUtils;
import cn.dianshi.vo.BlogQuery;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Transactional
@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public Blog getBlog(Long id) {
        return blogRepository.getOne(id);
    }

    @Override
    public Page<Blog> listBlog(Pageable pageable, BlogQuery blogQuery) {
        return blogRepository.findAll(new Specification<Blog>() {
            @Override
            public Predicate toPredicate(Root<Blog> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (!"".equals(blogQuery.getTitle()) && blogQuery.getTitle() != null){
                    predicates.add(criteriaBuilder.like(root.<String>get("title"),"%" + blogQuery.getTitle() + "%"));
                }
                if (blogQuery.getTypeId() != null){
                    predicates.add(criteriaBuilder.equal(root.<Type>get("type").get("id"),blogQuery.getTypeId()));
                }
                if (blogQuery.isRecommend()){
                    predicates.add(criteriaBuilder.equal(root.<Boolean>get("recommend"),blogQuery.isRecommend()));
                }
                query.where(predicates.toArray(new Predicate[predicates.size()]));
                return null;
            }
        },pageable);
    }

    @Override
    public Blog saveBlog(Blog blog) {
        if (blog.getId() == null){
            blog.setCreateTime(new Date());
            blog.setUpdateTime(new Date());
            blog.setViews(0);
        } else {
            blog.setUpdateTime(new Date());
        }
        return blogRepository.save(blog);
    }

    @Override
    public Blog updateBlog(Long id, Blog blog) throws NotFoundException {
        Blog b = blogRepository.getOne(id);
        if (b == null){
            throw new NotFoundException("该博客不存在");
        }
        BeanUtils.copyProperties(blog,b, MyBeanUtils.getNullPropertyNames(blog));
        b.setUpdateTime(new Date());
        return blogRepository.save(b);
    }

    @Override
    public void deleteBlog(Long id) {
        blogRepository.deleteById(id);
    }
}
