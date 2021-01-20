package com.wyx.esresthighlevelclientapidemo.deleteApi;

import com.wyx.esresthighlevelclientapidemo.config.EsConstant;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
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
public class DeleteDemoTest {

	@Resource
	private RestHighLevelClient restHighLevelClient;

	@Test
	public void test() throws IOException {
		DeleteRequest deleteRequest = new DeleteRequest(EsConstant.INDEX)
				.id("1");

		DeleteResponse deleteResponse = restHighLevelClient.delete(deleteRequest, RequestOptions.DEFAULT);
		System.out.println(deleteResponse);
	}
}
