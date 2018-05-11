package com.xingjiejian.wenda.web.servlet.index;

import com.alibaba.fastjson.JSON;
import com.xingjiejian.wenda.biz.CategoryBiz;
import com.xingjiejian.wenda.biz.impl.CategoryBizImpl;
import com.xingjiejian.wenda.entity.Category;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * 首页获取分类列表
 */
@WebServlet(name = "CategoryServlet",urlPatterns = "/index/category")
public class CategoryServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO

        //获取分类列表
        CategoryBiz categoryBiz = new CategoryBizImpl();
        //查询前20个分类
        List<Category> categories = categoryBiz.findPages(1,5);

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.print(JSON.toJSONString(categories));

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
