package com.signin.controllers;

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

        String encodeURL = resp.encodeURL(req.getContextPath());
        if(userName.equals("Bingxu")&&password.equals("hbx20011124")) {
            req.getSession().invalidate();
            HttpSession newSession = req.getSession(true);
            newSession.setMaxInactiveInterval(300);

            HttpSession session = req.getSession(true);
            session.setAttribute("userName",userName);

            resp.sendRedirect(encodeURL+"/memberPage?action=memberPage");
        } else {
            resp.sendRedirect(encodeURL+"/login?action=login");
        }
    }
}
