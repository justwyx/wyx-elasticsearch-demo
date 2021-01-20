package com.wyx.esresthighlevelclientapidemo.updateApi;

import com.wyx.esresthighlevelclientapidemo.config.EsConstant;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
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
public class UpdateDemoTest {
	@Resource
	private RestHighLevelClient restHighLevelClient;

	@Test
	public void test() throws IOException {
		Map<String, Object> jsonMap = new HashMap<>();
		jsonMap.put("updated", new Date());
		jsonMap.put("reason", "daily update");

		UpdateRequest updateRequest = new UpdateRequest(EsConstant.INDEX, "1")
//				.doc("{" +
//						"\"message\":\"2021-01-01\"," +
//						"\"user\":\"wyx\"" +
//						"}", XContentType.JSON)
				.doc(jsonMap)
				;
		UpdateResponse updateResponse = restHighLevelClient.update(updateRequest, RequestOptions.DEFAULT);
		System.out.println(updateResponse);
	}

//	@Test
//	public void testUpsert() throws IOException {
//		UpdateRequest updateRequest = new UpdateRequest(EsConstant.INDEX, "2")
//				.upsert("{" +
//						"\"message\":\"2021-01-01\"," +
//						"\"user\":\"wyx\"" +
//						"}", XContentType.JSON);
//		UpdateResponse updateResponse = restHighLevelClient.update(updateRequest, RequestOptions.DEFAULT);
//		System.out.println(updateResponse);
//	}
}
