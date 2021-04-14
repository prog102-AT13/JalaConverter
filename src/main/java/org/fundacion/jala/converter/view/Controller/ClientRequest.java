package org.fundacion.jala.converter.view.Controller;
/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Saul Caspa Miranda
 * @version 1.0
 */

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.fundacion.jala.converter.view.Models.IrequestForm;
import org.fundacion.jala.converter.view.Models.Parameter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

public class ClientRequest {
    private String sURL;
    private CloseableHttpClient httpClient;
    private HttpPost httpPost;
    private MultipartEntityBuilder builder;
    private HttpEntity multipart;
    private IrequestForm requestForm;

    /**
     * Http client creates a request given a requestForm.
     */
    public ClientRequest(IrequestForm requestForm) {
        this.requestForm = requestForm;
        this.sURL = requestForm.getURL();
        this.httpClient = HttpClients.createDefault();
    }

    /**
     * Executes a request given the type of requestForm.
     * @return
     * @throws ClientProtocolException
     * @throws IOException
     */
    public String executeRequest(IrequestForm requestForm) throws ClientProtocolException, IOException {
        httpPost = new HttpPost(sURL);
        builder = MultipartEntityBuilder.create();
        multipart = builder.build();
        addBodyFields();
        httpPost.setEntity(multipart);
        httpPost.setHeader("Authorization", "Bearer " + authGetToken());
        CloseableHttpResponse response = httpClient.execute(httpPost);
        HttpEntity responseEntity = response.getEntity();
        String sResponse = EntityUtils.toString(responseEntity, "UTF-8");
        System.out.println("Post return result" + sResponse);
        return sResponse;
    }

    /**
     * Retrieves a  token from the endpoint from a username and password.
     * @return
     */
    public CompletableFuture<String> authGetToken() {
        String url = "http://localhost:8080/authenticate";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(URI.create(url))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString("{\n" +
                        "    \"username\":\"at13\",\n" +
                        "    \"password\":\"jalasoft\"\n" +
                        "}")).
                        uri(URI.create(url)).
                        build();
        return client.sendAsync(request, HttpResponse.BodyHandlers.ofString()).thenApply(HttpResponse::body);
    }

    /**
     * Adds text field to http request.
     * @param key
     * @param value
     */
    public void addTextBody(String key, String value) {
        builder.addTextBody(key, value, ContentType.TEXT_PLAIN);
    }

    /**
     * Adds file field to http request.
     * @param key
     * @param filePath
     */
    public void addFileBody(String key, String filePath) {
        try {
            File f = new File(filePath);
            builder.addBinaryBody(
                    key,
                    new FileInputStream(filePath),
                    ContentType.APPLICATION_OCTET_STREAM,
                    f.getName()
            );
        } catch (Exception e) {

        }
    }

    /**
     * Iterates trough the body parameters.
     */
    public void addBodyFields() {
        requestForm.getBodyParameters().stream().forEach(value -> addBodyField(value));
    }

    /**
     * Adds a body field with the parameter's information.
     * @param parameter
     */
    public void addBodyField(Parameter parameter) {
        if (!parameter.isFile()) {
            addTextBody(parameter.getKey(), parameter.getValue());
        } else {
            addFileBody(parameter.getKey(), parameter.getValue());
        }
    }
}
