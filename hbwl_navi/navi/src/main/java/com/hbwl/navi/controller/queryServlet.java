package com.hbwl.navi.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import com.hbwl.navi.dto.Site;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/queryServlet")
public class queryServlet extends HttpServlet {
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
            out.print("<tr>\n" +
                    "<td>\n" +
                    "<label class=\"lyear-checkbox checkbox-primary\">\n" +
                    "<input type=\"checkbox\" name=\"ids[]\" value=\"2\"><span></span>\n" +
                    "</label>\n" +
                    "</td>\n" +
                    "<td>"+group.getId()+"</td>\n" +
                    "<td>"+group.getCategoryName()+"</td>\n" +
                    "<td>"+group.getWebsiteName()+"</td>\n" +
                    "<td>"+group.getSite()+"</td>\n" +
                    "<td>"+group.getIntroduction()+"</td>\n" +
                    "<td>\n" +
                    "<div class=\"btn-group\">\n" +
                    "<a class=\"btn btn-xs btn-default\" href=\"#!\" title=\"编辑\" data-toggle=\"tooltip\"><i class=\"mdi mdi-pencil\"></i></a>\n" +
                    "<a class=\"btn btn-xs btn-default\" href=\"#!\" title=\"查看\" data-toggle=\"tooltip\"><i class=\"mdi mdi-eye\"></i></a>\n" +
                    "<a class=\"btn btn-xs btn-default\" href=\"#!\" title=\"删除\" data-toggle=\"tooltip\"><i class=\"mdi mdi-window-close\"></i></a>\n" +
                    "</div>\n" +
                    "</td>\n" +
                    "</tr>");
        }
        out.flush();


    }
}


