package com.wyx.esresthighlevelclientapidemo.searchApi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.wyx.esresthighlevelclientapidemo.config.EsConstant;
import com.wyx.esresthighlevelclientapidemo.utils.JsonUtil;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author : Just wyx
 * @Date : 2021/1/20
 */
@SpringBootTest
public class SearchDemoTest {

	@Resource
	private RestHighLevelClient restHighLevelClient;

	@Test
	public void test() throws IOException {
		MatchQueryBuilder queryBuilder = QueryBuilders.matchQuery("user", "kimchy2");

		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder()
				.query(queryBuilder)
				.sort(new FieldSortBuilder("_id").order(SortOrder.DESC))
				.from(0)
				.size(5)
				;

		SearchRequest searchRequest = new SearchRequest(EsConstant.INDEX)
				.source(searchSourceBuilder);



		SearchResponse search = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);

		System.out.println(JsonUtil.toPrettyFormat(search.toString()));
	}


}
