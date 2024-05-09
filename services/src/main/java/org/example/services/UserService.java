package org.example.services;


import lombok.experimental.UtilityClass;
import org.example.dao.UserDao;
import org.example.dao.entities.User;
import org.example.dto.UserDto;

@UtilityClass
public class UserService {
    public static UserDto getUserById(Integer id){
       User u = UserDao.getById(id);
        return UserDto.builder().name(u.getFirstName()+" "+u.getSecondName()+" "+u.getThirdName())
                .id(u.getId())
                .email(u.getUserContactInfo().getEmail())
                .address(u.getUserContactInfo().getAddress())
                .number(u.getUserContactInfo().getTelephone().toString())
                .birthsDate(u.getBirthDate().toString())
                .build();
    }
}
