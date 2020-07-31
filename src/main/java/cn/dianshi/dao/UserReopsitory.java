package cn.dianshi.dao;

import cn.dianshi.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Dianshi
 */

@Repository
public interface UserReopsitory extends JpaRepository<User,Long> {
    public abstract User findByUsernameAndPassword(String username, String password);
}
