package dao.repository;

import dao.entity.User;
import dao.entity.Users;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ListOfUsers {

    public ArrayList<User> getListOfUsers(ArrayList<User> userList){
        String sql1 = "SELECT name FROM user";


        try (
                Datasource dataSource = new Datasource();
                // get connection with our database
                Connection connection = dataSource.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql1)
        )
        {
            if(resultSet.next()) {
                Users users = new Users();
                users.setUsers((ArrayList<User>) resultSet.getArray("name"));

                userList.add(users);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
