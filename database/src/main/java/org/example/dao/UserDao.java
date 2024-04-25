package org.example.dao;

import org.example.dao.entities.User;
import org.example.dbconnecrion.DbConnectionManager;

import java.sql.*;

public class UserDao {

    private UserDao() {
    }

    public static void createUser(User user) {

        String sqlNewId = "insert into users default values";


        try (Connection connection = DbConnectionManager.get()) {
            connection.setAutoCommit(false);

            PreparedStatement statement = connection.prepareStatement(sqlNewId, Statement.RETURN_GENERATED_KEYS);
            statement.execute();
            ResultSet rs = statement.getGeneratedKeys();
            rs.next();
            int neWid = rs.getInt(1);

            System.out.println("дошел 1 " + neWid);

            user.setId(neWid);

            String sqlNewNames = "insert into names (id, first_name, second_name, third_name) values (?,?,?,?)";

            statement = connection.prepareStatement(sqlNewNames);

            statement.setInt(1, user.getId());

            statement.setString(2, user.getFirstName());

            statement.setString(3, user.getSecondName());

            statement.setString(4, user.getThirdName());


            statement.execute();

            String sqlNewInfo = "insert into info (id, sex, births_date, job) values (?,?,?,?)";


            statement = connection.prepareStatement(sqlNewInfo);

            statement.setInt(1, user.getId());
            statement.setString(2, user.getSex());
            statement.setObject(3, user.getBirthDate());
            statement.setString(4, user.getJob());

            statement.execute();


            String sqlNewContactInfo = "insert into contact_info (id, address, telephone, email) values (?,?,?,?)";


            statement = connection.prepareStatement(sqlNewContactInfo);

            statement.setInt(1, user.getId());
            statement.setString(2, user.getUserContactInfo().getAddress());
            statement.setString(4, user.getUserContactInfo().getEmail());
            statement.setLong(3, user.getUserContactInfo().getTelephone());


            statement.execute();

            if (user.getUserRoles() != null) {
                String sqlNewRole = "insert into user_user_roles (user_id, user_role_id) values (?,?)";

                statement = connection.prepareStatement(sqlNewRole);

                statement.setInt(1, user.getId());
                statement.setInt(2, user.getUserRoles().getId());
            }

            statement.execute();

            connection.commit();


        } catch (SQLException e) {
            System.out.println(e);
        }


    }


}
