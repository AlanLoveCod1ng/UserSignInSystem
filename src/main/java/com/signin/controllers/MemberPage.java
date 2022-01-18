package com.signin.controllers;

import org.hibernate.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/memberPage")
public class MemberPage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        switch (action){
            case "destroy":
                req.getSession().invalidate();
                resp.sendRedirect(req.getContextPath()+"/login?action=login");
                break;
            case "memberPage":
                req.getRequestDispatcher("/logInPart/memberPage.jsp").forward(req,resp);
            case "memberOnly":
                req.getRequestDispatcher("/logInPart/memberOnly.jsp").forward(req,resp);
            default: break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req,resp);
    }
}
