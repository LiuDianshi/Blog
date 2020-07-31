package cn.dianshi.service;

import cn.dianshi.domain.User;

public interface UserService {

    public abstract User checkUser(String username, String password);
}
