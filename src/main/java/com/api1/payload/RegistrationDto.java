package com.api1.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationDto
{
    @Size(min = 3 , message = "Min should be 3 characters")
    private String name ;
    @Email
    private String email ;
    @Size(min = 10 , max = 10, message = "should be 10 digits" )
    private String mobile;


}
