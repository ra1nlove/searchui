package com.searchui.es;

import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rain on 17-4-11.
 */
public class Result {

    private long total;
    private List<Page> pages = new ArrayList<Page>();

    public Result(long total,List<Page> pages){
        this.total = total;
        this.pages = pages;
    }


    public float getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<Page> getPages() {
        return pages;
    }

    public void setPages(List<Page> pages) {
        this.pages = pages;
    }



}
