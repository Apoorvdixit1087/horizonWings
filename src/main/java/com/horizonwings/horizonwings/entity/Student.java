//package com.horizonwings.horizonwings.entity;
//
//import com.horizonwings.horizonwings.model.Gender;
//import com.horizonwings.horizonwings.model.PreviouEducation;
//import jakarta.persistence.*;
//import jakarta.validation.constraints.NotNull;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import org.hibernate.annotations.CreationTimestamp;
//
//import java.time.LocalDateTime;
//
//@Entity
//@Getter
//@Setter
//@NoArgsConstructor
//public class Student {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Integer id;
//    @NotNull
//    private String name;
//    @NotNull
//    private String emailId;
//    @NotNull
//    private String mobile;
//    private String countryCode;
//    @Enumerated(EnumType.STRING)
//    private Gender gender;
//
//    @Enumerated(EnumType.STRING)
//    private PreviouEducation previouEducation;
//
//    @CreationTimestamp
//    private LocalDateTime createdAt;
//
//    public Student(String name, String emailId, String mobile, String countryCode, Gender gender, PreviouEducation previouEducation) {
//        this.name = name;
//        this.emailId = emailId;
//        this.mobile = mobile;
//        this.countryCode = countryCode;
//        this.gender = gender;
//        this.previouEducation = previouEducation;
//    }
//}
