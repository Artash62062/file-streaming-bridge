package com.example.filesender.api.resource;

import com.example.filesender.api.platfrom.streming.FileStreamingService;
import com.example.filesender.api.sockets.CloudConnectionSocket;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.*;


import static org.springframework.http.MediaType.*;

/**
 * @author Artash Srabyan
 * Company: SFL LLC
 * Date: 27.09.21
 */
@RestController
@RequestMapping("/")
public class FileResource {
    @GetMapping(produces = APPLICATION_OCTET_STREAM_VALUE)
    @ResponseBody
    public void streamFile(HttpServletResponse response,@RequestParam String fileName) throws IOException {
        CloudConnectionSocket cloudConnectionSocket = new CloudConnectionSocket(fileName);
        FileStreamingService.streamFile(response,cloudConnectionSocket);
    }
}

