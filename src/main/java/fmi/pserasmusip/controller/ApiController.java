package fmi.pserasmusip.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ApiController {

    @RequestMapping(value = "/api", method = RequestMethod.GET)
    public String api() {
        return "api";
    }

}