package fr.afcepf.adi.dependancyinjection.controllers;

import services.GreetingService;
import org.springframework.stereotype.Controller;

@Controller
public class MyController {
    private final GreetingService greetingService;

    public MyController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String sayHello(){
        //return "Hi folks";

        return greetingService.sayGreeting();
    }
}
