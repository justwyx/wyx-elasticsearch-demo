package com.wyx.esresthighlevelclientapidemo.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : Just wyx
 * @Date : 2021/1/20
 */
@Configuration
public class ElasticsearchConfig {
	@Bean(name = "restHighLevelClient")
	public RestHighLevelClient restHighLevelClient(){
		return new RestHighLevelClient(RestClient.builder(
				new HttpHost("localhost", 9200, "http")));
	}
}
