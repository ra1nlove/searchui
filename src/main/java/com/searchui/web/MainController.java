package com.searchui.web;

import com.searchui.es.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * Created by rain on 17-4-4.
 */

@Controller
class MainController {

    @RequestMapping(value="search",method = RequestMethod.GET)
    public ModelAndView index(
                @RequestParam("keyword") String keyword,
                @RequestParam("page") int page){

        Query query = new Query();
        Map<String,String> map = query.query(keyword,page);
        ModelAndView mv = new ModelAndView();
        mv.addObject("message",map.get("data"));
        mv.addObject("total",map.get("total"));
        mv.setViewName("search");
        return mv;

    }

}
