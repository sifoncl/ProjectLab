package org.example.dao;

import org.example.dao.entities.analysis.Biochemical;
import org.example.dao.entities.analysis.OAK;
import org.example.dbconnecrion.DbConnectionManager;

import java.sql.*;
import java.util.ArrayList;

public class OAKDao {
    private OAKDao() {
    }

    public static OAK getById(Integer id) {
        String sql = """
                select id, id_user,
                date_time_get_material, date_time_added_result, 
                rbc, wbc, trobocitis, hb, hematocrit,
                cp, reticulocitis,
                soe, palochkoydernie_granulociti,
                segmentoydernie_granulociti, eosinofiles,
                basofiles, limfocites, monocites,
                metolmielocites, mielocites
                from oak_results
                where id =?
                """;
        try (Connection connection = DbConnectionManager.get();
             PreparedStatement statement = connection.prepareStatement(sql)) {


            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            rs.next();

            return OAKMapper(rs);

        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public static OAK addNewOAK(OAK oak) {
        String sql = """
                insert into OAK_results (id_user,
                date_time_get_material, date_time_added_result, 
                rbc, wbc, trobocitis, hb, hematocrit,
                cp, reticulocitis,
                soe, palochkoydernie_granulociti,
                segmentoydernie_granulociti, eosinofiles,
                basofiles, limfocites, monocites,
                metolmielocites, mielocites)
                values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);
                """;

        try (Connection connection = DbConnectionManager.get();
             PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            statement.setInt(1, oak.getUserId());
            statement.setDate(2, Date.valueOf(oak.getGetMatirial().toLocalDate()));
            statement.setDate(3, Date.valueOf(oak.getAddedResult().toLocalDate()));
            statement.setInt(4, oak.getRbc());
            statement.setInt(5, oak.getWbc());
            statement.setInt(6, oak.getTrombocitis());
            statement.setDouble(7, oak.getHb());
            statement.setDouble(8, oak.getHematocritis());
            statement.setDouble(9, oak.getSoe());
            statement.setDouble(10, oak.getCp());
            statement.setDouble(11, oak.getReticulocitis());
            statement.setDouble(12, oak.getPalochkoydernieGranulociti());
            statement.setDouble(13, oak.getSegmentoydernieGranulociti());
            statement.setDouble(14, oak.getEosinofiles());
            statement.setDouble(15, oak.getBasofiles());
            statement.setDouble(16, oak.getLimfocities());
            statement.setDouble(17, oak.getMonocities());
            statement.setDouble(18, oak.getMetolmielocites());
            statement.setDouble(19, oak.getMielocities());

            boolean a = statement.execute();
            ResultSet rs = statement.getGeneratedKeys();

            Integer id = null;
            if (rs.next()) {
                id = rs.getInt("id");
            }
            oak.setId(id);
            return oak;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return oak;
    }

    public static void deleteById(Integer id) {
        String sql = """
                        delete from public.oak_results
                        where id =?
                """;
        try (Connection connection = DbConnectionManager.get();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public static OAK updateOakById (OAK oak, Integer id){

        String sql = """
                update OAK_results set id_user=?,
                date_time_get_material=?, date_time_added_result=?, 
                rbc=?, wbc=?, trobocitis=?, hb=?, hematocrit=?,
                cp=?, reticulocitis=?,
                soe=?, palochkoydernie_granulociti=?,
                segmentoydernie_granulociti=?, eosinofiles=?,
                basofiles=?, limfocites=?, monocites=?,
                metolmielocites=?, mielocites=?
                where id = ?;
                """;
        OAK oakToUpdate = OAKDao.getById(id);

        if(oak.getUserId()!=null){
            oakToUpdate.setUserId(oak.getUserId());
        }
        if(oak.getAddedResult()!=null){
            oakToUpdate.setAddedResult(oak.getAddedResult());
        }
        if(oak.getRbc()!=null){
            oakToUpdate.setRbc(oak.getRbc());
        }
        if(oak.getWbc()!=null){
            oakToUpdate.setWbc(oak.getWbc());
        }
        if(oak.getTrombocitis()!=null){
            oakToUpdate.setTrombocitis(oak.getTrombocitis());
        }
        if(oak.getHb()!=null){
            oakToUpdate.setHb(oak.getHb());
        }
        if(oak.getHematocritis()!=null){
            oakToUpdate.setHematocritis(oak.getHematocritis());
        }
        if(oak.getCp()!=null){
            oakToUpdate.setCp(oak.getCp());
        }
        if(oak.getReticulocitis()!=null){
            oakToUpdate.setReticulocitis(oak.getReticulocitis());
        }
        if(oak.getSoe()!=null){
            oakToUpdate.setSoe(oak.getSoe());
        }
        if(oak.getPalochkoydernieGranulociti()!=null){
            oakToUpdate.setPalochkoydernieGranulociti(oak.getPalochkoydernieGranulociti());
        }
        if(oak.getSegmentoydernieGranulociti()!=null){
            oakToUpdate.setSegmentoydernieGranulociti(oak.getSegmentoydernieGranulociti());
        }
        if(oak.getEosinofiles()!=null){
            oakToUpdate.setEosinofiles(oak.getEosinofiles());
        }
        if(oak.getBasofiles()!=null){
            oakToUpdate.setBasofiles(oak.getBasofiles());
        }
        if(oak.getLimfocities()!=null){
            oakToUpdate.setLimfocities(oak.getLimfocities());
        }
        if(oak.getMonocities()!=null){
            oakToUpdate.setMonocities(oak.getMonocities());
        }
        if(oak.getMetolmielocites()!=null){
            oakToUpdate.setMetolmielocites(oak.getMetolmielocites());
        }
        if(oak.getMielocities()!=null){
            oakToUpdate.setMielocities(oak.getMielocities());
        }

        try (Connection connection = DbConnectionManager.get();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, oak.getUserId());
            statement.setDate(2, Date.valueOf(oak.getGetMatirial().toLocalDate()));
            statement.setDate(3, Date.valueOf(oak.getAddedResult().toLocalDate()));
            statement.setInt(4, oak.getRbc());
            statement.setInt(5, oak.getWbc());
            statement.setInt(6, oak.getTrombocitis());
            statement.setDouble(7, oak.getHb());
            statement.setDouble(8, oak.getHematocritis());
            statement.setDouble(9, oak.getSoe());
            statement.setDouble(10, oak.getCp());
            statement.setDouble(11, oak.getReticulocitis());
            statement.setDouble(12, oak.getPalochkoydernieGranulociti());
            statement.setDouble(13, oak.getSegmentoydernieGranulociti());
            statement.setDouble(14, oak.getEosinofiles());
            statement.setDouble(15, oak.getBasofiles());
            statement.setDouble(16, oak.getLimfocities());
            statement.setDouble(17, oak.getMonocities());
            statement.setDouble(18, oak.getMetolmielocites());
            statement.setDouble(19, oak.getMielocities());
            statement.setInt(20, id);

            statement.execute();

            return oakToUpdate;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return oakToUpdate;
    }


    public static ArrayList<OAK> saveAllUserOAKResults(Integer userId){
        ArrayList<OAK> results= new ArrayList<>();
        String sql= """
              select id, id_user,
                date_time_get_material, date_time_added_result, 
                rbc, wbc, trobocitis, hb, hematocrit,
                cp, reticulocitis,
                soe, palochkoydernie_granulociti,
                segmentoydernie_granulociti, eosinofiles,
                basofiles, limfocites, monocites,
                metolmielocites, mielocites
                from oak_results
                where id_user =?
                """;
        try (Connection connection = DbConnectionManager.get();
             PreparedStatement statement = connection.prepareStatement(sql)) {


            statement.setInt(1, userId);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                results.add(OAKMapper(rs));
            }
            return results;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    private static OAK OAKMapper(ResultSet rs) throws SQLException {
        return OAK.OAKBuilder.anOAK()
                .withId(rs.getInt("id"))
                .withUserId(rs.getInt("id_user"))
                .withAddedResult(rs.getDate("date_time_added_result").toLocalDate().atStartOfDay())
                .withGetMatirial(rs.getDate("date_time_get_material").toLocalDate().atStartOfDay())
                .withRbc(rs.getInt("RBC"))
                .withWbc(rs.getInt("WBC"))
                .withTrombocitis(rs.getInt("trobocitis"))
                .withHb(rs.getDouble("hb"))
                .withHematocritis(rs.getDouble("hematocrit"))
                .withCp(rs.getDouble("cp"))
                .withReticulocitis(rs.getDouble("reticulocitis"))
                .withSoe(Integer.valueOf(rs.getInt("soe")).doubleValue())
                .withPalochkoydernieGranulociti(rs.getDouble("palochkoydernie_granulociti"))
                .withSegmentoydernieGranulociti(rs.getDouble("segmentoydernie_granulociti"))
                .withEosinofiles(rs.getDouble("eosinofiles"))
                .withBasofiles(rs.getDouble("basofiles"))
                .withLimfocities(rs.getDouble("limfocites"))
                .withMonocities(rs.getDouble("monocites"))
                .withMetolmielocites(rs.getDouble("metolmielocites"))
                .withMielocities(rs.getDouble("mielocites"))
                .build();
    }
}





