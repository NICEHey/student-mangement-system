package com.itevent.web.servlet;

import com.itevent.domain.Users;
import com.itevent.service.UserService;
import com.itevent.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.设置编码
        request.setCharacterEncoding("utf-8");

        //2.获取数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String verifycode = request.getParameter("verifycode");


        //3.判断验证码是否正确
        HttpSession session = request.getSession();
        String checkCode = (String)session.getAttribute("checkCode");
        session.removeAttribute("checkCode");
        if (verifycode == null || ! checkCode.equalsIgnoreCase(verifycode)){
            request.setAttribute("login_msg","验证码错误！");
            //跳转登录页面
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            return;
        }


        //4.封装user对象
        Users users = new Users();
        users.setUsername(username);
        users.setPassword(password);

        //5.调用service中的登录方法
        UserService service = new UserServiceImpl();
        Users adm = service.login(users);


        //6.判断输入的数据是否正确
        if (adm != null){
            /*getRequestDispatcher和sendRedirect的区别？？？？？？
            request.getRequestDispatcher("/index.jsp").forward(request,response);
            */
            //验证成功
            //将用户数据保存到session中

            session.setAttribute("adm",adm);
            //跳转页面
            response.sendRedirect(request.getContextPath()+"/findAllServlet");
        }else {
            request.setAttribute("login_msg","用户名或密码错误！");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
