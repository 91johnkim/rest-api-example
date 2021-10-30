package com.backpacker.userapi.orders;


import com.backpacker.userapi.common.BaseEntity;
import com.backpacker.userapi.users.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "ProductOrder")
public class Order extends BaseEntity {
    @Id @GeneratedValue
    private String id;

    @OneToOne
    @JoinColumn(name="user_id", referencedColumnName = "id", nullable = false)
    private User user;

    @Column(length = 100)
    private String productName;

    @Column(columnDefinition = "datetime")
    private LocalDateTime payedAt;
}
