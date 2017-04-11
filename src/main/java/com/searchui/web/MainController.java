package com.searchui.web;

import com.searchui.es.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * Created by rain on 17-4-4.
 */

@RestController
class MainController {

    @RequestMapping(value="search",method = RequestMethod.GET)
    public ModelAndView index(
                @RequestParam("keyword") String keyword,
                @RequestParam("page") int page){

        Query query = new Query();
//        Map<String,String> map = query.query(keyword,page);
        ModelAndView mv = new ModelAndView();
  //      mv.addObject("message",map.get("data"));
 //       mv.addObject("total",map.get("total"));
        mv.setViewName("search");
        return mv;

    }

    @RequestMapping(value = "get",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public String getPages(
            @RequestParam("keyword") String keyword,
            @RequestParam("page") int page){
        Query query = new Query();
        String data = query.query(keyword,page);
        return data;

    }


}
