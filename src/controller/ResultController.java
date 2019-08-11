package controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.mysql.cj.xdevapi.JsonArray;
import entity.User;
import service.ITestService;
import service.impl.UserSeriveIMpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResultController extends HttpServlet {

    private ITestService iTestService = new UserSeriveIMpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object age = req.getSession().getAttribute("age");
        String s = String.valueOf(age);
        List<User> userAge = null;
        try {
            userAge = iTestService.findByUserAge(Integer.valueOf(s));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        resp.setCharacterEncoding("UTF-8");
        String jsonString = JSONArray.toJSONString(userAge);
        resp.getWriter().write(jsonString);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
