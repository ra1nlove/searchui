package com.searchui.es;

import com.alibaba.fastjson.JSON;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rain on 17-4-4.
 */
public class Query {

    TransportClient client ;

    public Query() {
        try {
            client = new PreBuiltTransportClient(Settings.EMPTY).addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("10.108.113.231"), 9300));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public String query(String keyword, int pagenum){

        List<Page> pages = new ArrayList<Page>();

        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.preTags("<em>");
        highlightBuilder.postTags("</em>");
        highlightBuilder.field("content");
        highlightBuilder.field("title");
        highlightBuilder.field("desc");

        SearchResponse response = client.prepareSearch("web").setTypes("page")
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                .setQuery(QueryBuilders.multiMatchQuery(keyword,"title","desc","content","keyword"))
                .highlighter(highlightBuilder)
                .setSize(10)
                .setFrom(pagenum*10)
                .get();

        for(SearchHit hit : response.getHits()){
            String title = null;
            String desc = null;
            String url;

            if(hit.getHighlightFields().get("title")!=null){
                title = hit.getHighlightFields().get("title").getFragments()[0].toString();
            }else if(hit.getSource().get("title")!=null){
                title = hit.getSource().get("title").toString();
            }
            if(title == null) continue;

            if(hit.getHighlightFields().get("desc")!=null){
                desc = hit.getHighlightFields().get("desc").getFragments()[0].toString();
            }else if(hit.getSource().get("desc")!=null){
                desc = hit.getSource().get("desc").toString();
            }

            if(desc ==null){
                if(hit.getHighlightFields().get("content")!=null){
                    desc = hit.getHighlightFields().get("content").getFragments()[0].toString();
                }else if(hit.getSource().get("content")!=null){
                    desc = hit.getSource().get("content").toString();
                }
            }

            if(desc.length()>100){
                desc = desc.substring(0,100);
            }
            url = hit.getSource().get("url").toString();

            Page page = new Page(title,desc,url);
            pages.add(page);
        }

        Result res = new Result(response.getHits().totalHits(),pages);
        String data = JSON.toJSONString(res);

       return data;
    }

    public static void main(String[] args) throws Exception{
        Query query = new Query();
        System.out.print(query.query("sina",0));
    }

}
