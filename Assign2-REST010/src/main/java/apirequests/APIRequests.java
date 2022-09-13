package apirequests;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class APIRequests {

    public static JSONArray getPartsList() throws IOException {

        URL url = new URL("http://localhost:8080/client/getPartsList");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();

        while ((inputLine = input.readLine()) != null) {
            content.append(inputLine);
        }

        input.close();
        connection.disconnect();

        System.out.println(content);
        JSONArray jsonArray = new JSONArray(content.toString());
        return jsonArray;
    }

    public static JSONArray getClientsList() throws IOException {

        URL url = new URL("http://localhost:8080/agent/getClientList");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();

        while ((inputLine = input.readLine()) != null) {
            content.append(inputLine);
        }

        input.close();
        connection.disconnect();
        System.out.println(content);

        JSONArray jsonArray = new JSONArray(content.toString());
        return jsonArray;
    }

    public static JSONArray getAgentsList() throws IOException {

        URL url = new URL("http://localhost:8080/agent/getAgentList");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();

        while ((inputLine = input.readLine()) != null) {
            content.append(inputLine);
        }

        input.close();
        connection.disconnect();


        System.out.println(content);
        JSONArray jsonArray = new JSONArray(content.toString());
        return jsonArray;
    }

    public static JSONArray getDetailedPOClient(int clientCompId010, int poNo010) throws IOException {
        URL url = new URL("http://localhost:8080/client/getDetailedPO");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("clientCompId010", String.valueOf(clientCompId010));
        connection.setRequestProperty("poNo010", String.valueOf(poNo010));

        BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();

        while ((inputLine = input.readLine()) != null) {
            content.append(inputLine);
        }

        input.close();
        connection.disconnect();

        System.out.println(content);
        JSONArray jsonArray = new JSONArray(content.toString());
        return jsonArray;
    }

    public static JSONArray getPartOrderListForAgent() throws IOException {
        URL url = new URL("http://localhost:8080/agent/getPOList");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();

        while ((inputLine = input.readLine()) != null) {
            content.append(inputLine);
        }

        input.close();
        connection.disconnect();

        System.out.println(content);
        JSONArray jsonArray = new JSONArray(content.toString());
        return jsonArray;
    }

    public static JSONArray getPartOrderListForClient(int clientCompId010) throws IOException {
        URL url = new URL("http://localhost:8080/client/getPOList?clientCompId010="+clientCompId010);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();

        while ((inputLine = input.readLine()) != null) {
            content.append(inputLine);
        }

        input.close();
        connection.disconnect();

        System.out.println(content);
        JSONArray jsonArray = new JSONArray(content.toString());
        return jsonArray;
    }


    public static void createNewPo(int clientCompId010, int partNo010, Integer poNo010) throws UnsupportedEncodingException {
        HttpPost post = new HttpPost("http://localhost:8080/client/postNewOrder");

        // add request parameter, form parameters
        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair("clientCompId010", String.valueOf(clientCompId010)));
        urlParameters.add(new BasicNameValuePair("partNo010", String.valueOf(partNo010)));
        if (poNo010 != null)
            urlParameters.add(new BasicNameValuePair("poNo010", String.valueOf(poNo010)));

        post.setEntity(new UrlEncodedFormEntity(urlParameters));

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(post)) {

            System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createNewPoTest(String newOrderInput) throws UnsupportedEncodingException {
        HttpPost post = new HttpPost("http://localhost:8080/client/postNewOrderTest");
        StringEntity entity = new StringEntity(newOrderInput);
        post.setEntity(entity);
        post.addHeader("Accept", "application/json");
        post.addHeader("Content-type", "application/json");

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(post)) {

            System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void updatePart(int partNo010, String partName010, String partDescription010, Float currentPrice010, Integer currentQty010) throws UnsupportedEncodingException {
        HttpPost post = new HttpPost("http://localhost:8080/agent/updatePart");

        // add request parameter, form parameters
        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair("partNo010", String.valueOf(partNo010)));
        if(partName010 != null)
            urlParameters.add(new BasicNameValuePair("partName010", partName010));
        if(partDescription010 != null)
            urlParameters.add(new BasicNameValuePair("partDescription010", partDescription010));
        if(currentPrice010 != null)
            urlParameters.add(new BasicNameValuePair("currentPrice010", String.valueOf(currentPrice010)));
        if (currentQty010 != null)
            urlParameters.add(new BasicNameValuePair("currentQty010", String.valueOf(currentQty010)));
        post.setEntity(new UrlEncodedFormEntity(urlParameters));

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(post)) {

            System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void updatePoStatus(String status010, int poNo010) throws UnsupportedEncodingException {
        HttpPost post = new HttpPost("http://localhost:8080/agent/updatePoStatus");

        // add request parameter, form parameters
        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair("poNo010", String.valueOf(poNo010)));
        urlParameters.add(new BasicNameValuePair("status010", status010));
        post.setEntity(new UrlEncodedFormEntity(urlParameters));

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(post)) {

            System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static JSONArray getPartOrderLine(int poNo010) throws IOException {
        URL url = new URL("http://localhost:8080/client/findPoLines?poNo010="+poNo010);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();

        while ((inputLine = input.readLine()) != null) {
            content.append(inputLine);
        }

        input.close();
        connection.disconnect();
        System.out.println(content);
        JSONArray jsonArray = new JSONArray(content.toString());
        return jsonArray;
    }
}

