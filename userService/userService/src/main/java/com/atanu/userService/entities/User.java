package com.atanu.userService.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
@Scope("prototype")
public class User {
    @Id
    private String userId;

    @Column(name = "user_name")
    private String userName;

    @Column(unique = true, name = "user_phone")
    private long userPhone;

    @Column(name = "user_address")
    private String userAddress;
}
