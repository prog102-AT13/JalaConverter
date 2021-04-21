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
package org.fundacion.jala.converter.view.controllers;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.fundacion.jala.converter.view.Models.IRequestForm;
import org.fundacion.jala.converter.view.Models.Parameter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.fundacion.jala.converter.models.UserSQL.findUserById;

public class ClientRequest {
    private CloseableHttpClient httpClient;
    private HttpPost httpPost;
    private MultipartEntityBuilder builder;
    private HttpEntity multipart;
    private IRequestForm requestForm;
    private final String defaultCharset = "UTF-8";
    private static final Logger LOGGER = LogManager.getLogger();
    private String token;

    /**
     * Gets token
     * @return a String with the token
     */
    public String getToken() {
        return token;
    }

    /**
     * Sets the token value
     * @param newToken the new value for the token
     */
    public void setToken(final String newToken) {
        this.token = newToken;
    }

    /**
     * Http client creates a request given a requestForm.
     */
    public ClientRequest() {
        this.httpClient = HttpClients.createDefault();
    }

    /**
     * Executes a request given the type of requestForm.
     * @return sResponse
     * @throws ClientProtocolException
     * @throws IOException
     */
    public String executeRequest(final IRequestForm newRequestForm) throws ClientProtocolException, IOException {
        requestForm = newRequestForm;
        httpPost = new HttpPost(requestForm.getURL());
        builder = MultipartEntityBuilder.create();
        addBodyFields();
        multipart = builder.build();
        httpPost.setEntity(multipart);
        System.out.println("------------------------");
        System.out.println(token);
        System.out.println("------------------------");
        httpPost.setHeader("Authorization", "Bearer " + findUserById(1).getToken());
        CloseableHttpResponse response = httpClient.execute(httpPost);
        HttpEntity responseEntity = response.getEntity();
        String sResponse = EntityUtils.toString(responseEntity, defaultCharset);
        return sResponse;
    }

    /**
     * Executes a request given the type of requestForm
     * @param newRequestForm the request form
     * @return a String with the response
     * @throws ClientProtocolException when an error on the HTTP protocol occurs
     * @throws IOException when an invalid input is provided
     */
    public String executeRequestWithoutToken(final IRequestForm newRequestForm)
            throws ClientProtocolException, IOException {
        requestForm = newRequestForm;
        httpPost = new HttpPost(requestForm.getURL());
        builder = MultipartEntityBuilder.create();
        addBodyFields();
        multipart = builder.build();
        httpPost.setEntity(multipart);
        CloseableHttpResponse response = httpClient.execute(httpPost);
        HttpEntity responseEntity = response.getEntity();
        String sResponse = EntityUtils.toString(responseEntity, "UTF-8");
        return sResponse;
    }

    /**
     * Downloads a file from endpoint to given path
     * @throws ClientProtocolException
     * @throws IOException
     */
    public void download(final String filePath) throws IOException{
        String sURL = "http://localhost:8080/api/download/img1.png";
        CloseableHttpClient localHttpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet(sURL);
        request.setHeader("Authorization", "Bearer " + findUserById(1).getToken());
        CloseableHttpResponse response = localHttpClient.execute(request);
        HttpEntity responseEntity = response.getEntity();
        InputStream inputStream = responseEntity.getContent();
        FileOutputStream outputStream = new FileOutputStream(new File(filePath));
        int inByte;
        while ((inByte = inputStream.read()) != -1) {
            outputStream.write(inByte);
        }
        inputStream.close();
        outputStream.close();
    }

    /**
     * Retrieves a  token from the endpoint from a username and password.
     * @return
     */
    public String authGetToken() throws IOException {
        String sURL = "http://localhost:8080/authenticate";
        CloseableHttpClient localHttpClient = HttpClients.createDefault();
        HttpPost request = new HttpPost(sURL);
        StringEntity params = new StringEntity("{\n"
                + "    \"username\":\"at13\",\n"
                + "    \"password\":\"jalasoft\"\n" + "}");
        request.addHeader("Content-Type", "application/json");
        request.setEntity(params);
        CloseableHttpResponse response = localHttpClient.execute(request);
        HttpEntity responseEntity = response.getEntity();
        String localToken = EntityUtils.toString(responseEntity, "UTF-8");
        return localToken;
    }

    /**
     * Adds text field to http request.
     * @param key String with the key
     * @param value String with the value
     */
    public void addTextBody(final String key, final String value) {
        builder.addTextBody(key, value, ContentType.TEXT_PLAIN);
    }

    /**
     * Adds file field to http request.
     * @param key String with the key
     * @param filePath String with the value
     */
    public void addFileBody(final String key, final String filePath) {
        LOGGER.info("Start");
        try {
            LOGGER.info("Execute Try");
            File f = new File(filePath);
            builder.addBinaryBody(
                    key,
                    new FileInputStream(filePath),
                    ContentType.APPLICATION_OCTET_STREAM,
                    f.getName()
            );
        } catch (Exception e) {
            LOGGER.error("Execute Exception to add file field to http request");
            e.printStackTrace();
        }
        LOGGER.info("Finish");
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
    public void addBodyField(final Parameter parameter) {
        if (!parameter.isFile()) {
            addTextBody(parameter.getKey(), parameter.getValue());
        } else {
            addFileBody(parameter.getKey(), parameter.getValue());
        }
    }
}
