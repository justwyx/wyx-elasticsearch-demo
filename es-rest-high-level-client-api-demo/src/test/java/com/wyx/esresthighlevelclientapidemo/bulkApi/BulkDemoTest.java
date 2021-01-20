package com.wyx.esresthighlevelclientapidemo.bulkApi;

import com.wyx.esresthighlevelclientapidemo.config.EsConstant;
import org.elasticsearch.action.bulk.BulkItemResponse;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author : Just wyx
 * @Date : 2021/1/20
 */
@SpringBootTest
public class BulkDemoTest {

	@Resource
	private RestHighLevelClient restHighLevelClient;

	@Test
	public void test() throws IOException {
		BulkRequest bulkRequest = new BulkRequest();
		bulkRequest.add(new IndexRequest(EsConstant.INDEX)
				.id("1")
				.source(XContentType.JSON,"field", "foo"));
		bulkRequest.add(new IndexRequest(EsConstant.INDEX)
				.id("2")
				.source(XContentType.JSON,"field", "bar"));
		bulkRequest.add(new IndexRequest(EsConstant.INDEX)
				.id("3")
				.source(XContentType.JSON,"field", "baz"));
		BulkResponse bulkResponse = restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);

		for (BulkItemResponse item : bulkResponse.getItems()) {
			System.out.println(item.getIndex() + ":" + item.getResponse());
		}

	}
}
