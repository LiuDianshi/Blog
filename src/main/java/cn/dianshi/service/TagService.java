package cn.dianshi.service;

import cn.dianshi.domain.Tag;
import cn.dianshi.exception.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TagService {
    public abstract Tag saveTag(Tag tag);

    public abstract Tag getTag(Long id);

    public abstract Tag getTagByName(String name);

    public abstract Page<Tag> listTag(Pageable pageable);

    public abstract List<Tag> listTag();

    public abstract List<Tag> listTagTop(Integer size);

    public abstract List<Tag> listTag(String ids);

    public abstract Tag updateTag(Long id, Tag tag) throws NotFoundException;

    public abstract void deleteTag(Long id);
}
