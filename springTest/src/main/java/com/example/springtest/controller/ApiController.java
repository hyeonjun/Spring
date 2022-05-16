package com.example.springtest.controller;

import com.example.springtest.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@RestController
@RequestMapping("/api")
@Validated
@Slf4j
public class ApiController {

    @PostMapping("/user") // @Valid: 해당 Object에 validation 실행
    public ResponseEntity user(@Valid @RequestBody User user, BindingResult bindingResult) {
        // BindingResult: 예외 발생 시 Validation의 결과가 담김
        if (bindingResult.hasErrors()) {
            StringBuilder sb = new StringBuilder();
            bindingResult.getAllErrors().forEach(e -> {
                FieldError field = (FieldError) e;
                String message = e.getDefaultMessage();

                sb.append("field: ").append(field.getField()).append("\n");
                sb.append("message: ").append(message);
            });
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sb.toString());
        }
        return ResponseEntity.ok(user);
    }

    @GetMapping("")
    public User get(
            @Size(min = 2)
            @RequestParam String name,
            @NotNull @Min(1)
            @RequestParam Integer age) {
        User user = User.builder()
                .name(name)
                .age(age)
                .build();
        return user;
    }

    @PostMapping("")
    public User post(@Valid @RequestBody User user) {
        log.info("User: {}", user);
        return user;
    }




}
