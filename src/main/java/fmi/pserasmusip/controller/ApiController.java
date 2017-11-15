package fmi.pserasmusip.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @RequestMapping(value = "/api", method = RequestMethod.GET)
    public String api() {
        return "Api";
    }

}