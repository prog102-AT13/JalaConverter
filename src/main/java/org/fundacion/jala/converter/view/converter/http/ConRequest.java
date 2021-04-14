package org.fundacion.jala.converter.view.converter.http;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConRequest {

    public void sendConRequest(String urlEndPoint) {
        callEndPoint(urlEndPoint);
    }

    private void callEndPoint(String urlEndPoint) {
        try {
            URL url = new URL("http://localhost:8080/api/convertAudio");
            String postData = "file=/home/cristian/Desktop/audio/ringtones-iphone-8-plus.wav&"
                    + "format=mp3&"
                    + "bitrate=128&"
                    + "volume=1&"
                    + "hz=44&"
                    + "audiochannel=mono&"
                    + "metadata=true";
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Authorization", "Bearer " + "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhdDEzIiwiZXhwIjoxNjE4NDQyNzQ4LCJpYXQiOjE2MTg0MDY3NDh9.L7mdmB37kcHhhbhhYrZ6yGTy4lBfTQ6ZPe6xL3BKl7A");
            conn.setRequestProperty("Content-Length", Integer.toString(postData.length()));
            conn.setUseCaches(false);

            try (DataOutputStream dos = new DataOutputStream(conn.getOutputStream())) {
                dos.writeBytes(postData);
            }

            try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
