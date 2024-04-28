package org.example.dao;

import org.example.dao.entities.analysis.Biochemical;
import org.example.dbconnecrion.DbConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
