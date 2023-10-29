package sample.spring.security.controllers;

import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping({"", "/" , "/Index"})
    public String getIndexPage(){
        return "Index";
    }
}
