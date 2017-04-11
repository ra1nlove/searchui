package com.searchui.es;

/**
 * Created by rain on 17-4-11.
 */
public class Result {
    String title ;
    String text;
    String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Result(String title, String text, String url){
        this.text = text;
        this.title = title;
        this.url = url;

    }
}
