package com.example.songr.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HelloController {
    @GetMapping("/")
    public String getHelloWorld(){


        return "helloworld.html";
    }


    @GetMapping("/hello")
    public String getHello(){


        return "helloworld.html";
    }
}
