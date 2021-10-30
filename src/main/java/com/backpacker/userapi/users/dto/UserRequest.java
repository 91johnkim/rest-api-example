package com.backpacker.userapi.users.dto;

import com.backpacker.userapi.users.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.*;


@Builder @Data @NoArgsConstructor @AllArgsConstructor
public class UserRequest {

    @Email
    @NotEmpty
    @Size(max=100)
    private String email;

    @NotBlank
    @Size(max=20)
    @Pattern(regexp = "^[ㄱ-ㅎ가-힣a-zA-Z]*$")
    private String name;

    @NotBlank
    @Size(max=30)
    @Pattern(regexp = "^[a-z]*$")
    private String nickName;

    @NotBlank
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{10,20}")
    private String password;
    
    @Pattern(regexp = "^01(?:0|1|[6-9])[.-]?(\\d{3}|\\d{4})[.-]?(\\d{4})$")
    private String phoneNumber;

    public User toEntity(){
        return User.builder()
                .name(this.name)
                .email(this.email)
                .nickName(this.nickName)
                .password(this.password)
                .phoneNumber(this.phoneNumber)
                .build();
    }
}
