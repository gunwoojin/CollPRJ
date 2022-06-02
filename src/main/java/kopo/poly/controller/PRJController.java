package kopo.poly.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class PRJController {


    @GetMapping(value = "PRJindex")
    public String Index() {
        return "/PRJ/PRJIndex";

    }

    @GetMapping(value = "PRJmain")
    public String Main() {
        return "PRJ/PRJMain";
    }


    @RequestMapping(value = "/PRJ/myPage")
    public String MyPage(){
        return "/PRJ/myPage1";
    }

    @RequestMapping(value = "/PRJ/myPage2")
    public String MyPage2(){
        return "/PRJ/myPage2";
    }

    @RequestMapping(value = "/PRJ/myPage3")
    public String MyPage3(){
        return "/PRJ/myPage3";
    }

}
