package org.iclass.myboard.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserDto {

    private String userId;
    private String userName;
    private String passWord;
    private Date birth;
    private String gender;
    private String email;
    private Date regDate;
}
