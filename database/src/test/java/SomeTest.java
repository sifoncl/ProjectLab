import org.example.dao.BiochemicalDao;
import org.example.dao.OAKDao;
import org.example.dao.entities.analysis.Biochemical;
import org.example.dao.entities.analysis.OAK;
import org.example.dbconnecrion.DbConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class SomeTest {

    public static void main(String[] args) throws SQLException {

        Connection connection = DbConnectionManager.get();
        System.out.println(connection.getTransactionIsolation());
//        LocalDate birthsDate = LocalDate.of(2002,12,24);

//        UserContactInfo uCi= UserContactInfo.UserContactInfoBuilder.anUserContactInfo()
//                .withAddress("улица пушкина дом колатушкина")
//                .withTelephone(89062325456L)
//                .build();
//
//        User user = User.UserBuilder.anUser().
//        withFirstName("VASYA4").withSecondName("null").withThirdName("Жоркин")
//                .withBirthDate(birthsDate)
//                .withSex("F")
//                .withJob("fjjfj")
//                .withUserContactInfo(uCi)
//                .withUserRoles(UserRoles.PATIENT)
//                .build();
//
//        System.out.println(UserRoles.ADMIN.getId());
//        System.out.println(UserDao.saveUserById(3));
//
//
//

//            UserDao.createUser(user);
//
//        Biochemical bc = BiochemicalDao.getById(40);
//
//        Biochemical bc2 = BiochemicalDao.addNewResult(bc);
//
//        System.out.println(bc2);
//
//      BiochemicalDao.deleteById(bc.getId());
//
//        System.out.println(bc2.getId());
//
//        System.out.println(BiochemicalDao.getById(bc2.getId()));


//
//        Biochemical bc = BiochemicalDao.getById(1);
//
//        bc.setUserId(4);
//
//        Biochemical bc2 = BiochemicalDao.updateById(bc, bc.getId());

//        User user = UserDao.getById(1);
//
//        System.out.println(user);
//
//        user.setFirstName("Петя");
//
//        UserDao.updateById(user, user.getId());
//
//        OAK oak = OAKDao.getById(35);
//        System.out.println(oak);
//
//        oak.setBasofiles(1000.0);
//
//        OAKDao.updateOakById(oak, 36);
//
//        ArrayList<Biochemical> res = BiochemicalDao.saveAllUserBcResults(4);
//
//        for (Biochemical bc: res){
//            System.out.println(bc);
//        }

        ArrayList<OAK> res = OAKDao.saveAllUserOAKResults(6);

        for (OAK oak: res){
            System.out.println(oak);
        }
    }


}
