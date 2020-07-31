package cn.dianshi.dao;

import cn.dianshi.domain.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Dianshi
 */
@Repository
public interface TypeReposiory extends JpaRepository<Type,Long> {
    public abstract Type findTypeByName(String name);
}
