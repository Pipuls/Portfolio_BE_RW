package com.portfolioapbe.ger.Security.Dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter @Setter
public class UserLogin {

    @NotBlank
    private String userName;
    @NotBlank
    private String password;
}
