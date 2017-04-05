package com.searchui.es;

import org.apache.lucene.queryparser.flexible.core.builders.QueryBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;

/**
 * Created by rain on 17-4-4.
 */
public class Query {

    TransportClient client ;

    public Query() throws Exception{
        client = new PreBuiltTransportClient(Settings.EMPTY).addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("10.108.113.231"),9300));
    }

    public void query(String keyword){

        SearchResponse response = client.prepareSearch("page").setTypes("fulltext")
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH).setQuery(QueryBuilders.termQuery("content",keyword))
                .get();


    }

    public static void main(String[] args) throws Exception{
        Query query = new Query();
        query.query("新浪");
    }

}
