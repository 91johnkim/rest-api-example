package com.backpacker.userapi.users;

import com.backpacker.userapi.users.dto.UserRequest;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component
public class UserValidator {

    public void validate(UserRequest userDto , Errors errors){

        //패스워드 검증
        //이메일 길이검증


    }
}
