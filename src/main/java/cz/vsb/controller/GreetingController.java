package cz.vsb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    @RequestMapping(value = {"/hello", "/hello/"}, method = RequestMethod.GET) //get je defaultně a nemusí se uvádět
    public String greeting(){
        return "Hello";
    }
}
