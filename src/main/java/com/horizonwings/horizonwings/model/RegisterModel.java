package com.horizonwings.horizonwings.model;

//import jakarta.persistence.EnumType;
//import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RegisterModel {

    private String name;
    private String emailId;
    private String mobile;
    private String countryCode;
    private String gender;
    private String previousEducation;
}
