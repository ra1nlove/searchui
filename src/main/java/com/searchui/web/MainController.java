package com.searchui.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by rain on 17-4-4.
 */

@Controller
class MainController {

    @RequestMapping(value="index",method = RequestMethod.GET)
    public String index(){
        return "index";
    }

}
