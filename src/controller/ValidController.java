package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ValidController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String age = req.getParameter("age");
        try {
            int currentAge = Integer.parseInt(age);
            if (currentAge > 150) {
                resp.setCharacterEncoding("UTF-8");
                resp.getWriter().write("年龄不正确");
            }
        } catch (Exception e) {
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write("年龄不正确");
        }
        System.out.println(age);

    }
}

