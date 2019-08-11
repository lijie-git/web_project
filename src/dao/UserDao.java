package dao;

import entity.User;
import util.MysqlUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {


    public int addUser(User user) throws SQLException, IOException, ClassNotFoundException {
        Connection conn = MysqlUtil.getInstance().getConnection();
        int i = 0;
        String sql = "insert into test2(name,age) values(?,?)";
        PreparedStatement pstmt;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getName());
            pstmt.setInt(2, user.getAge());

            i = pstmt.executeUpdate();
            System.out.println("----------------------------");
            System.out.println("我的sql:"+sql);
            System.out.println("----------------------------");
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }


    public User findUserByID(int id) throws SQLException, IOException, ClassNotFoundException {
        Connection conn = MysqlUtil.getInstance().getConnection();
        int i = 0;
        String sql = "select * from test1 where id=?";
        PreparedStatement pstmt;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet resultSet = pstmt.executeQuery();
            if (resultSet != null && resultSet.next()) {
                User u = new User();
                u.setId(resultSet.getInt(1));
                u.setName(resultSet.getString(2));
                u.setAge(resultSet.getInt(3));
                return u;
            }
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public List<User> findUserByAge(int age) throws SQLException, IOException, ClassNotFoundException {
        Connection conn = MysqlUtil.getInstance().getConnection();
        String sql = "select * from test1 where age=?";
        PreparedStatement pstmt;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, age);
            ResultSet resultSet = pstmt.executeQuery();
            List<User> list = new ArrayList<>();
            while (resultSet != null && resultSet.next()) {
                User u = new User();
                u.setId(resultSet.getInt(1));
                u.setName(resultSet.getString(2));
                u.setAge(resultSet.getInt(3));
                list.add(u);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
