package com.example.server;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/download")
@RequiredArgsConstructor
public class DownloadController {

    private final String directoryLocation;

    @SneakyThrows
    @GetMapping(produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public @ResponseBody byte[] download(@RequestParam String fileName) {
        InputStream resourceAsStream = new FileInputStream(directoryLocation + "/" + fileName);
        return resourceAsStream.readAllBytes();
    }

    @GetMapping("/names")
    public String fileNames() {
        return Stream.of(new File(directoryLocation).listFiles())
                .map(File::getName)
                .collect(Collectors.joining(","));
    }
}
