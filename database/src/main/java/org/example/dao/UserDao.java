package org.example.dao;

import org.example.dao.entities.User;
import org.example.dao.entities.UserContactInfo;
import org.example.dao.entities.UserRoles;
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

    public static User saveUserById(Integer id) {
        String sqlUserById = """
       select address,
       telephone,
       email,
       first_name,
       second_name,
       third_name,
       sex,
       births_date,
       job,
       user_role_id,
       ur.id,
       ur.name
from users
         join contact_info ci on users.id = ci.id
         join names n on users.id = n.id
         join info i2 on users.id = i2.id
         left join user_user_roles uur on users.id = uur.user_id
         left outer join user_roles ur on uur.user_role_id = ur.id
where user_id = ?
               """;

        try (Connection connection = DbConnectionManager.get()) {

            PreparedStatement statement = connection.prepareStatement(sqlUserById);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            rs.next();
            return userMapper(rs);

        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;

    }

    public static void deleteUserById (Integer id){
        String sqlUser = "delete from user where id =?";

    }

    private static User userMapper (ResultSet rs) throws SQLException {
        return
        User.UserBuilder.anUser().
                withId(rs.getInt("id")).
                withFirstName(rs.getString("first_name")).
                withSecondName(rs.getString("second_name")).
                withThirdName(rs.getString("third_name")).
                withUserContactInfo(
                        new UserContactInfo(rs.getInt("id"),rs.getString("address"),
                        rs.getLong("telephone"), rs.getString("email"))).
                withJob(rs.getString("job")).
                withSex(rs.getString("sex")).
                withBirthDate(rs.getDate("births_date").toLocalDate())
                .withUserRoles(UserRoles.getRoleById(rs.getInt("user_role_id"))).build();
    }




}