package com.atanu.userService.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDto {
    private String userId;

    @NotEmpty(message = "user name field can't be blank")
    private String userName;

    @NotBlank
    @Pattern(regexp = "(^[0-9]{10})",message = "please provide a valid phone number")
    private String userPhone;

    @NotBlank(message = "Address can't be blank")
    private String userAddress;
}
