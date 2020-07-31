package cn.dianshi.service.Impl;

import cn.dianshi.dao.UserReopsitory;
import cn.dianshi.domain.User;
import cn.dianshi.service.UserService;
import cn.dianshi.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserReopsitory userReopsitory;

    @Override
    public User checkUser(String username, String password) {
        User user = userReopsitory.findByUsernameAndPassword(username, MD5Utils.code(password));
        return user;
    }
}
