package com.grupo02.web;

//import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HelloController {
    
    /*@GetMapping("/")
    public String getMethodName(@RequestParam String param) {
        return new String();
    }*/
    @GetMapping("/greeting")
    public String greet(@RequestParam(name="name", required=false, defaultValue="Mundo") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
    
}
