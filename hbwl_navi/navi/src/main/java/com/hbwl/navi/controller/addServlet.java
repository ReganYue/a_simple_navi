package com.hbwl.navi.controller;

import cn.hutool.db.Db;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/addServlet")
public class addServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String category_name = request.getParameter("category_name");
        String website_name = request.getParameter("website_name");
        String site = request.getParameter("site");
        String introduction = request.getParameter("introduction");

        //新增
        try {
            Db.use().execute("insert into site values (?, ?, ?, ?, ?)", null,category_name, website_name,site,introduction);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect("admin/query.jsp");
    }
}
