package com.yilmazmehmet.rentraapi.model;

 
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupForm {
   @NotBlank
   @Size(min = 3, max = 50)
   private String name;

   @NotBlank
   @Size(min = 3, max = 50)
   private String username;

   @NotBlank
   @Size(max = 60)
   @Email
   private String email;
   
   private Set<String> role;
   
   @NotBlank
   @Size(min = 6, max = 40)
   private String password;
}
