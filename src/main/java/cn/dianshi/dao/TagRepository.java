package cn.dianshi.dao;

import cn.dianshi.domain.Tag;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.Future;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
    public abstract Tag findTagByName(String name);

    @Query("select t from Tag t")
    public abstract List<Tag> findTop(Pageable pageable);

}
