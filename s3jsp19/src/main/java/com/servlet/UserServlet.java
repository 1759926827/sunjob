package com.servlet;

import com.mapper.UserDAO;
import com.pojo.UserInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UserServlet extends HttpServlet {

    private UserDAO userDAO = new UserDAO();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String p = request.getParameter("p");

        if("findall".equals(p)){
            doFindAll(request , response);
        }

    }

    private void doFindAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<UserInfo> list = userDAO.findall();
        request.setAttribute("list" , list);
        request.getRequestDispatcher("show.jsp").forward(request , response);



    }
}
