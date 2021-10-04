package com.example.filesender.api.sockets;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * @author Artash Srabyan
 * Company: SFL LLC
 * Date: 04.10.21
 */
public class CloudConnectionSocket {
    private final String baseUrl = "http://localhost:8080";
    private final URL url;
    private HttpURLConnection httpURLConnection;

    public CloudConnectionSocket(String filePath) throws IOException {
        url = new URL(baseUrl + filePath);
        httpURLConnection = (HttpURLConnection) url.openConnection();
    }

    public HttpURLConnection getHttpURLConnection() {
        return httpURLConnection;
    }

    public CloudConnectionSocket setHttpURLConnection(HttpURLConnection httpURLConnection) {
        this.httpURLConnection = httpURLConnection;
        return this;
    }
}
