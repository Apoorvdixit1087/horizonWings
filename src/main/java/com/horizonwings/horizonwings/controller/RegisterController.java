package com.horizonwings.horizonwings.controller;

import com.horizonwings.horizonwings.model.RegisterModel;
import com.horizonwings.horizonwings.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {

    @Autowired
    RegisterService registerService;
    @PostMapping("/api/v1/registerStudent")
    public ResponseEntity<?> registerStudent(@RequestBody RegisterModel registerModel){
        String msg = registerService.registerStudent(registerModel);
        return ResponseEntity.ok(msg);

    }
}
