package cn.dianshi.dao;

import cn.dianshi.domain.Type;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Dianshi
 */
@Repository
public interface TypeReposiory extends JpaRepository<Type,Long> {
    public abstract Type findTypeByName(String name);

    @Query("select t from Type t")
    public abstract List<Type> findTop(Pageable pageable);
}
