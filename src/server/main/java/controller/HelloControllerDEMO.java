package controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloControllerDEMO {

    @GetMapping("sayHello")
    public String sayHello() {
        return "Hello World!";
    }

}
