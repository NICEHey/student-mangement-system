package com.itevent.web.servlet;

import com.itevent.service.UserService;
import com.itevent.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delServlet")
public class DelServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.设置编码
        request.setCharacterEncoding("utf-8");

        //2.获取id
        String id = request.getParameter("id");

        //调用service中的delUser方法
        UserService service = new UserServiceImpl();
        service.delUser(id);

        //重定向到jsp页面
        /*request.getRequestDispatcher("list.jsp").forward(request,response);*/
        response.sendRedirect(request.getContextPath()+"/findAllServlet");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
