package com.signin.controllers;

import com.signin.App;
import com.signin.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LogInController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action){
            case "login":req.getRequestDispatcher("/logInPart/login.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");

        User user = new User();
        try{
            user = App.getUser(userName);
        }catch (Exception e){
            resp.sendRedirect(req.getContextPath()+"/login?action=login");
            return;
        }

        if(password.equals(user.getPassword())) {
            req.getSession().invalidate();
            HttpSession newSession = req.getSession(true);
            newSession.setMaxInactiveInterval(300);

            HttpSession session = req.getSession(true);
            session.setAttribute("userName",userName);
            session.setAttribute("user",user);
            resp.sendRedirect(req.getContextPath()+"/memberPage?action=memberPage");
        } else {
            resp.sendRedirect(req.getContextPath()+"/login?action=login");
        }
    }
}
