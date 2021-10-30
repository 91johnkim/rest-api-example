package com.backpacker.userapi.users.dto;

import com.backpacker.userapi.users.User;
import lombok.*;

@Getter @Setter
@Builder
public class UserResponse {

    private Integer id;
    private String name;
    private String email;
    private String nickName;
    private String phoneNumber;

    public static UserResponse create(User user){
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .nickName(user.getNickName())
                .phoneNumber(user.getPhoneNumber())
                .build();

    }
}
