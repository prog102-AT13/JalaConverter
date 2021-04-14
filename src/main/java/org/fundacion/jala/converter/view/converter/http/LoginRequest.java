package org.fundacion.jala.converter.view.converter.http;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

public class LoginRequest {

    static private String token;
    private String username;
    private String password;

    public LoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
        String body = getToken("http://localhost:8080/authenticate").join();
        setToken(body);
    }

    private CompletableFuture<String> getToken(String url) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(URI.create(url))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString("{\n"
                        + "\"username\":\"" + username + "\",\n"
                        + "\"password\":\"" + password + "\"\n"
                        + "}")).uri(URI.create(url)).build();
        return client.sendAsync(request, HttpResponse.BodyHandlers.ofString()).thenApply(HttpResponse::body);
    }

    private void setToken(String body) {
        char[] disarm = body .toCharArray();
        final int iniToken = 0;
        String token = "";
        for (int i = iniToken; i < disarm.length - 2; i++) {
            token = token + disarm[i];
        }
        this.token = token;
    }

    public static String getTokenUser() {
        return token;
    }

}
