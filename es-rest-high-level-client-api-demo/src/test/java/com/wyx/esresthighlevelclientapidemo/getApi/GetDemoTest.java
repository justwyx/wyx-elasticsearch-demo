package com.wyx.esresthighlevelclientapidemo.getApi;

import com.wyx.esresthighlevelclientapidemo.config.EsConstant;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author : Just wyx
 * @Date : 2021/1/20
 */
@SpringBootTest
public class GetDemoTest {

	@Resource
	private RestHighLevelClient restHighLevelClient;

	@Test
	public void test() throws IOException {
		GetRequest getRequest = new GetRequest(EsConstant.INDEX)
				.id("1");
		GetResponse getResponse = restHighLevelClient.get(getRequest, RequestOptions.DEFAULT);
		System.out.println(getResponse);

	}
}
