package com.hbwl.navi.dao;

import java.sql.SQLException;

public interface userDAO {
    //判断用户名是否存在
    public boolean existUsername(String username);
    //判断该用户名的密码是否正确
    public boolean pwdIsTrue(String username,String password);
}
