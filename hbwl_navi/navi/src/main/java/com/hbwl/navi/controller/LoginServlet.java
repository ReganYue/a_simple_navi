package com.hbwl.navi.controller;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import com.hbwl.navi.dao.userDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet implements userDAO {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-Type", "text/html; charset=utf-8");
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (existUsername(username)) {
            if (pwdIsTrue(username, password)) {
                System.out.println("登陆成功");
                response.sendRedirect("admin/query.jsp");
            } else {
                System.out.println("登陆失败");
                response.sendRedirect("admin/index.jsp");
            }
        } else {
            System.out.println("登陆失败");
            response.sendRedirect("admin/index.jsp");
        }
    }

    @Override
    public boolean existUsername(String username) {
        List<Entity> all = null;
        try {
            all = Db.use().query("select username from user where username=?", username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("username="+username);
        if (all.size() == 1 && all.get(0).containsValue(username)) {
            System.out.println("查询到用户名！");
            return true;
        } else {
            System.out.println(all.get(0));
            System.out.println("用户名不存在");
            return false;
        }

    }

    @Override
    public boolean pwdIsTrue(String username, String password) {
        List<Entity> result = null;
        try {
            //查询
            result = Db.use().query("select password from user where username=?", username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (result.size() == 1 && result.get(0).containsValue(password)) {
            System.out.println("密码正确！");
            return true;
        } else {
            System.out.println(result);
            System.out.println("用户名正确，密码错误！");
            return false;
        }

    }
}
