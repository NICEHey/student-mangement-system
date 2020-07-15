package com.itevent.web.servlet;

import com.itevent.domain.Users;
import com.itevent.service.UserService;
import com.itevent.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/findUserServlet")
public class FindUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.设置编码
        request.setCharacterEncoding("utf-8");

        //2.获取id
        String id = request.getParameter("id");

        //3.调用service中的findUser方法
        UserService service = new UserServiceImpl();
        Users user = service.finUser(id);

        //4.将数据保存到request域中
        request.setAttribute("user",user);

        //5.转发到update页面中
        request.getRequestDispatcher("/update.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
