import org.example.dao.UserDao;
import org.example.dto.BiochemicalDto;
import org.example.dto.UserDto;
import org.example.services.BiochemicalService;
import org.example.services.UserService;

import java.util.List;

public class SomeTest {
    public static void main(String[] args) {

        UserDto userDto = UserService.getUserById(4);
        System.out.println(userDto);
        System.out.println(userDto.getId());

//        List<BiochemicalDto> bcs = BiochemicalService.getAllUserResults(4);
//
//        System.out.println(bcs.get(2));
    }
}
