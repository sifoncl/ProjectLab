package org.example.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {
    private Integer id;
    private String name;
    private String number;
    private String address;
    private String email;
    private String birthsDate;

}
