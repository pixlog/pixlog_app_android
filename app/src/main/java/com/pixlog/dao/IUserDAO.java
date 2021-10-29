package com.pixlog.dao;

import java.util.List;

public interface IUserDAO {

    public boolean add(User user);
    public boolean update(User user);
    public List<User> get();

}
