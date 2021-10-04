package com.example.filesender.api.platfrom.streming;

import com.example.filesender.api.sockets.CloudConnectionSocket;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;

/**
 * @author Artash Srabyan
 * Company: SFL LLC
 * Date: 04.10.21
 */
public class FileStreamingService {
    private static final int BUFFER_SIZE = 4096;
    public static void streamFile(HttpServletResponse clientResponse, CloudConnectionSocket cloudConnectionSocket) throws IOException {
        HttpURLConnection cloudConnection = cloudConnectionSocket.getHttpURLConnection();
        int responseCode = cloudConnection.getResponseCode();
        String disposition = cloudConnection.getHeaderField("Content-Disposition");
        String contentType = cloudConnection.getContentType();
        int contentLength = cloudConnection.getContentLength();
        clientResponse.setContentLength(contentLength);
        clientResponse.setHeader("Content-Disposition", disposition);
        clientResponse.setContentType(contentType);
        InputStream inputStream = cloudConnection.getInputStream();
        OutputStream outputStream = clientResponse.getOutputStream();
        int bytesRead = -1;
        byte[] buffer = new byte[BUFFER_SIZE];
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }
        outputStream.close();
        inputStream.close();
    }
}
