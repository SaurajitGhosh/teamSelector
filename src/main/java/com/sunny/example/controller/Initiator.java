package com.sunny.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Saurajit on 4/18/19.
 */
@RestController
@RequestMapping(path = "/test")
public class Initiator {

    @RequestMapping("/testing")
    public String test(){
        return "Hello World";
    }
}
