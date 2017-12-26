package example1package;


import org.apache.http.HttpHost;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;

import java.io.IOException;

/**
 * Created by Евгений on 26.12.2017.
 */
public class Main {
    public static void main(String[] args) {
/*
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("localhost", 9200, "http")));
*/

        RestClient restClient = RestClient.builder(
                new HttpHost("localhost", 9200, "http")).build();

        try {
            Response response = restClient.performRequest("GET", "/bank/account/1?pretty");
            String responseBody = EntityUtils.toString(response.getEntity());
            System.out.println(responseBody);

            restClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("end");
    }
}
