package net.codejava;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class WebController {

    @GetMapping("/Home")
    public String sayHello(){

        return "index";
    }

}
