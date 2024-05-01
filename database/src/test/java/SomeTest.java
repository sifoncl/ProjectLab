import org.example.dao.BiochemicalDao;
import org.example.dao.UserDao;
import org.example.dao.entities.User;
import org.example.dao.entities.UserContactInfo;
import org.example.dao.entities.UserRoles;
import org.example.dao.entities.analysis.Biochemical;
import org.example.dbconnecrion.DbConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

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

        //      UserDao.createUser(user);

        Biochemical bc = BiochemicalDao.getById(1);

        Biochemical bc2 = BiochemicalDao.addNewResult(bc);

        System.out.println(bc2);

        BiochemicalDao.deleteById(bc.getId());

        System.out.println(bc2.getId());

        System.out.println(BiochemicalDao.getById(bc2.getId()));

    }


}
