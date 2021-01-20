package com.wyx.esresthighlevelclientapidemo.indexApi;

import com.wyx.esresthighlevelclientapidemo.config.EsConstant;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : Just wyx
 * @Date : 2021/1/20
 */
@SpringBootTest
public class IndexDemoTest {

	@Resource
	private RestHighLevelClient restHighLevelClient;



	@Test
	public void test() throws IOException {
		IndexRequest indexRequest;

//		indexRequest= new IndexRequest(EsConstant.INDEX)
//				.id("1")
//				.source("{" +
//						"\"user\":\"kimchy\"," +
//						"\"postDate\":\"2013-01-30\"," +
//						"\"message\":\"trying out Elasticsearch\"" +
//						"}", XContentType.JSON);

		Map<String, Object> jsonMap = new HashMap<>();
		jsonMap.put("user", "kimchy");
		jsonMap.put("postDate", new Date());
		jsonMap.put("message", "trying out Elasticsearch2");
		indexRequest = new IndexRequest(EsConstant.INDEX)
				.id("1")
				.source(jsonMap);

		IndexResponse indexResponse = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);

		System.out.println(indexResponse);
	}
}
