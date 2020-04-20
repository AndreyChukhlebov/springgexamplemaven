package com.example.demo.controller;


import com.example.demo.model.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class SimpleController {


    @RequestMapping(value = "/info", method = RequestMethod.POST)
    public User getInfo(@RequestBody User user) {
        return new User();
    }

}
