package cn.dianshi.controller;

import cn.dianshi.exception.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class IndexController {

    @GetMapping("/index")
    public String index() throws NotFoundException {
        int i = 5/0;
//        String blog = null;
//        if (blog == null){
//         throw new NotFoundException("Blog Not Found!");
//        }

        System.out.println("--------index-------");
        return "index";
    }

}
