package cn.dianshi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Dianshi
 */
@Controller
public class AboutShowController {

    @GetMapping(path = "/about")
    public String about(){
        return "about";
    }
}
