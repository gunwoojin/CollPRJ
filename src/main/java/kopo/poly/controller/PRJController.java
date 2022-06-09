package kopo.poly.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class PRJController {


    @GetMapping(value = "PRJmain")
    public String Main() {
        return "PRJ/PRJMain";
    }





}
