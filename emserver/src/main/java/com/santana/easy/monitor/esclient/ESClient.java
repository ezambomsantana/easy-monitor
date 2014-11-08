package com.santana.easy.monitor.esclient;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.index.query.FilterBuilders;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.node.Node;
import org.elasticsearch.search.SearchHit;

import com.santana.easy.monitor.model.UserLocalization;

public class ESClient {
	
	public void putData(String id, String lat, String lon) {

		
		Client client = new TransportClient().addTransportAddress(new InetSocketTransportAddress("localhost", 9300));
		
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("id", id);
		data.put("lat", lat);
		data.put("lon", lon);
		data.put("date", new Date());

		data.put("lon", lon);
		IndexResponse response = client.prepareIndex("em", "em")
		        .setSource(data)
		        .execute()
		        .actionGet();
		
		client.close();

	}
	
	public UserLocalization getLocalization(String id) {
		Client client = new TransportClient().addTransportAddress(new InetSocketTransportAddress("localhost", 9300));

	
		SearchResponse response = client.prepareSearch("em", "em")
		        .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
		        .setQuery(QueryBuilders.termQuery("id", id))             // Query
		        .setFrom(0).setSize(60).setExplain(true)
		        .execute()
		        .actionGet();
		
		SearchHit[] results = response.getHits().getHits();
		UserLocalization user = null;
		for (SearchHit hit : results) {
			user = new UserLocalization();
		  System.out.println(hit.getId());    //prints out the id of the document
		  Map<String,Object> result = hit.getSource();   //the retrieved document
		  user.setId((String) result.get("id")); 
		  user.setId((String) result.get("lat")); 
		  user.setId((String) result.get("lon")); 
		  
		}
		System.out.println("TEste");
		
		client.close();
		return user;
	}

}
