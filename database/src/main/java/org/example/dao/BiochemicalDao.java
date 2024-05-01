package org.example.dao;

import org.example.dao.entities.analysis.Biochemical;
import org.example.dbconnecrion.DbConnectionManager;

import java.sql.*;

public class BiochemicalDao {

    public static Biochemical getById(Integer id) {
        String sql = """
                select id, id_user, alt,
                 ast, creatinin, mochevina,
                  bilirubin_obsh, bilirubin_priamoi,
                   bilirubin_nepriamoi
                   , cholestirin, glucose,date_time_get_material,date_time_added_result from biochemical_results
                   where id = ?
                """;

        try (Connection connection = DbConnectionManager.get()) {
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            rs.next();
            return biochemicalMapper(rs);


        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public static Biochemical addNewResult(Biochemical bc) {
        String sql = """
                insert into biochemical_results 
                (id_user, date_time_get_material, date_time_added_result, ALT, AST, creatinin, mochevina, bilirubin_obsh,
                 bilirubin_priamoi, bilirubin_nepriamoi, cholestirin, glucose)
                values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);
                """;
        try (Connection connection = DbConnectionManager.get()) {
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            statement.setInt(1, bc.getUserId());
            statement.setDate(2, Date.valueOf(bc.getGetMatirial().toLocalDate()));
            statement.setDate(3, Date.valueOf(bc.getAddedResult().toLocalDate()));
            statement.setDouble(4, bc.getAlt());
            statement.setDouble(5, bc.getAst());
            statement.setDouble(6, bc.getCreatinin());
            statement.setDouble(7, bc.getMochevina());
            statement.setDouble(8, bc.getBilirubinObsh());
            statement.setDouble(9, bc.getBilirubinPriamoi());
            statement.setDouble(10, bc.getBilirubinNepriamoi());
            statement.setDouble(11, bc.getCholesterin());
            statement.setDouble(12, bc.getGlucose());

          boolean a =  statement.execute();

            ResultSet rs = statement.getGeneratedKeys();

            Integer id = null;

            if (rs.next()) {
                System.out.println("сюда зашел" + a);
                id = rs.getInt("id");
            }


            System.out.println("id анализа " + id);

            bc.setId(id);
            connection.commit();
            return bc;

        } catch (SQLException e) {
            System.out.println(e);
        }
        System.out.println("что то пошло не так");
        return bc;
    }


    public static void deleteById(Integer id) {
        String sql = "delete from biochemical_results where id = ?";
        try (Connection connection = DbConnectionManager.get()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    private static Biochemical biochemicalMapper(ResultSet rs) throws SQLException {
        return Biochemical.BiochemicalBuilder.aBiochemical()
                .withId(rs.getInt("id"))
                .withUserId(rs.getInt("id_user"))
                .withAlt(rs.getDouble("alt"))
                .withAst(rs.getDouble("ast"))
                .withCreatinin(rs.getDouble("creatinin"))
                .withMochevina(rs.getDouble("mochevina"))
                .withBilirubinObsh(rs.getDouble("bilirubin_obsh"))
                .withBilirubinPriamoi(rs.getDouble("bilirubin_priamoi"))
                .withBilirubinNepriamoi(rs.getDouble("bilirubin_nepriamoi"))
                .withCholesterin(rs.getDouble("cholestirin"))
                .withGlucose(rs.getDouble("glucose"))
                .withAddedResult(rs.getDate("date_time_added_result") == null ? null :
                        rs.getDate("date_time_added_result").toLocalDate().atTime(0, 0))
                .withGetMatirial(rs.getDate("date_time_get_material") == null ? null :
                        rs.getDate("date_time_get_material").toLocalDate().atTime(0, 0))
                .build();
    }
}
