package com.backpacker.userapi.users;

import com.backpacker.userapi.common.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Builder
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Entity
public class User extends BaseEntity {
    @Id @GeneratedValue
    private Integer id;

    @Column(nullable = false , unique = true, length = 100)
    private String email;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false ,length = 30)
    private String nickName;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false ,length = 20)
    private String phoneNumber;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private Set<UserRole> roles;
}
