package org.example.dao;

import org.example.dao.entities.analysis.Biochemical;
import org.example.dbconnecrion.DbConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;

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

        try (Connection connection = DbConnectionManager.get();
             PreparedStatement statement = connection.prepareStatement(sql)) {


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
        try (Connection connection = DbConnectionManager.get();
             PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

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

            boolean a = statement.execute();

            ResultSet rs = statement.getGeneratedKeys();

            Integer id = null;

            if (rs.next()) {

                id = rs.getInt("id");
            }
            bc.setId(id);
            return bc;

        } catch (SQLException e) {
            System.out.println(e);
        }
        return bc;
    }


    public static Biochemical updateById(Biochemical bc, Integer id) {
        Biochemical bcToUpdate = BiochemicalDao.getById(id);

        if (bc.getUserId() != null) {
            bcToUpdate.setUserId(bc.getUserId());
        }
        if (bc.getGetMatirial() != null) {
            bcToUpdate.setGetMatirial(bc.getGetMatirial());
        }
        if (bc.getAddedResult() != null) {
            bcToUpdate.setAddedResult(bc.getAddedResult());
        }
        if (bc.getAlt() != null) {
            bcToUpdate.setAlt(bc.getAlt());
        }
        if (bc.getAst() != null) {
            bcToUpdate.setAst(bc.getAst());
        }
        if (bc.getCreatinin() != null) {
            bcToUpdate.setCreatinin(bc.getCreatinin());
        }
        if (bc.getMochevina() != null) {
            bcToUpdate.setMochevina(bc.getMochevina());
        }
        if (bc.getBilirubinObsh() != null) {
            bcToUpdate.setBilirubinObsh(bc.getBilirubinObsh());
        }
        if (bc.getBilirubinPriamoi() != null) {
            bcToUpdate.setBilirubinPriamoi(bc.getBilirubinPriamoi());
        }
        if (bc.getBilirubinNepriamoi() != null) {
            bcToUpdate.setBilirubinNepriamoi(bc.getBilirubinNepriamoi());
        }
        if (bc.getCholesterin() != null) {
            bcToUpdate.setCholesterin(bc.getCholesterin());
        }
        if (bc.getGlucose() != null) {
            bcToUpdate.setGlucose(bc.getGlucose());
        }

        String sql = """
                update biochemical_results
                set id_user=?, date_time_get_material=?, date_time_added_result=?,
                    ALT=?, AST=?, creatinin=?, mochevina=?, bilirubin_obsh=?,
                    bilirubin_priamoi=?, bilirubin_nepriamoi=?, cholestirin=?, glucose=?
                where id =?
                 """;
        try (Connection connection = DbConnectionManager.get();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, bcToUpdate.getUserId());
            statement.setDate(2, Date.valueOf(bcToUpdate.getGetMatirial().toLocalDate()));
            statement.setDate(3, Date.valueOf(bcToUpdate.getAddedResult().toLocalDate()));
            statement.setDouble(4, bcToUpdate.getAlt());
            statement.setDouble(5, bcToUpdate.getAst());
            statement.setDouble(6, bcToUpdate.getCreatinin());
            statement.setDouble(7, bcToUpdate.getMochevina());
            statement.setDouble(8, bcToUpdate.getBilirubinObsh());
            statement.setDouble(9, bcToUpdate.getBilirubinPriamoi());
            statement.setDouble(10, bcToUpdate.getBilirubinNepriamoi());
            statement.setDouble(11, bcToUpdate.getCholesterin());
            statement.setDouble(12, bcToUpdate.getGlucose());
            statement.setInt(13, bcToUpdate.getId());

            statement.execute();

            return bcToUpdate;

        } catch (SQLException e) {
            System.out.println(e);
        }
        return bcToUpdate;
    }

    public static ArrayList<Biochemical> saveAllUserBcResults(Integer userId){
        ArrayList<Biochemical> results= new ArrayList<>();
        String sql= """
                select id, id_user, alt,
                ast, creatinin, mochevina,
                bilirubin_obsh, bilirubin_priamoi,
                bilirubin_nepriamoi,
                cholestirin, glucose,date_time_get_material,date_time_added_result 
                from biochemical_results
                   where id_user = ?
                """;
        try (Connection connection = DbConnectionManager.get();
             PreparedStatement statement = connection.prepareStatement(sql)) {


            statement.setInt(1, userId);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                results.add(biochemicalMapper(rs));
            }
            return results;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }



    public static void deleteById(Integer id) {
        String sql = "delete from biochemical_results where id = ?";
        try (Connection connection = DbConnectionManager.get();
             PreparedStatement statement = connection.prepareStatement(sql)) {

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
