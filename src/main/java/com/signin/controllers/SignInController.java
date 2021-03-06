package com.signin.controllers;

import com.signin.App;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/signin")
public class SignInController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/view/UserSignIn.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String [] languages = req.getParameterValues("language");
        String languageStr = "";
        for (String language : languages) {
            languageStr += language + "+";
        }
        App.insertNewUser(req.getParameter("userName"),req.getParameter("password"),req.getParameter("first_name"),req.getParameter("second_name"),req.getParameter("gender"), languageStr,req.getParameter("address"),
                Date.valueOf(req.getParameter("birth_date")), new Date(System.currentTimeMillis()),req.getParameter("nation"),req.getParameter("phone_number"));

        RequestDispatcher dispatcher = req.getRequestDispatcher("/view/SignInSuccess.jsp");
        dispatcher.forward(req,resp);
    }
}
