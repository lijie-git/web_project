package service;

import entity.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface ITestService {

    int addUser(User user) throws SQLException, IOException, ClassNotFoundException;

    User findUserByID(int id) throws SQLException, IOException, ClassNotFoundException;

    List<User> findByUserAge(int age) throws SQLException, IOException, ClassNotFoundException;
}
