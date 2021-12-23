package com.hbwl.navi.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import com.hbwl.navi.dto.Category;
import com.hbwl.navi.dto.Site;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/showListServlet")
public class showListServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-Type", "text/html; charset=utf-8");
        PrintWriter out = response.getWriter();
        List<Site> groupList = new ArrayList<>();
        try {
            List<Entity> sites = Db.use().findAll("site");
            for (Entity site : sites) {
                Site group = BeanUtil.toBean(site, Site.class);
                groupList.add(group);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        for(Site group:groupList){
//            out.print(group.getCategoryName()+group.getIntroduction()+group.getSite()+group.getWebsiteName());
            out.print("<div class=\"nav-list\">\n" +
                    "\t\t\t\t\t\t\t\t\t<h2 id=\""+group.getCategoryName()+"\">"+group.getCategoryName()+"</h2>\n" +
                    "\t\t\t\t\t\t\t\t\t<ul>\n" +
                    "\t\t\t\t\t\t\t\t\t\t\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t<li class=\"nav-box\">\n" +
                    "\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"nav-des\">\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<h3>"+group.getWebsiteName()+"</h3>\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<p>"+group.getIntroduction()+"</p>\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<a href=\""+group.getSite()+"\" class=\"nav-visit\">访问</a>\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t</li>\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "\t\t\t\t\t\t\t\t\t\t\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "\t\t\t\t\t\t\t\t\t\t\n" +
                    "\t\t\t\t\t\t\t\t\t</ul>\n" +
                    "\t\t\t\t\t\t\t\t</div>");
        }
        out.flush();
    }

}
