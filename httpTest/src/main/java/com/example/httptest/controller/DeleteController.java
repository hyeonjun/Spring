package com.example.httptest.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class DeleteController {

    @DeleteMapping("/delete/{userId}")
    public void delete(@PathVariable String userId, @RequestParam String account) {
        System.out.println(userId);
        System.out.println(account);
        
        // delete -> 리소스 삭제
        // 삭제할 리소스가 있어도 없어도 200 ok가 전달됨
    }

}
