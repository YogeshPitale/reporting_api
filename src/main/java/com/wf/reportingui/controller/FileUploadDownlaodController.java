package com.wf.reportingui.controller;

import com.wf.reportingui.entity.FileUploadResponse;
import com.wf.reportingui.service.FileStorageService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;

@RestController
public class FileUploadDownlaodController {
    @Autowired
    private FileStorageService fileStorageService;

    @PostMapping("/uploadFile")
    public ResponseEntity<FileUploadResponse> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        String filename = fileStorageService.storeFile(file);
        String url = ServletUriComponentsBuilder.fromCurrentContextPath().path("/download/").path(filename).toUriString();
        String contentType = file.getContentType();
        FileUploadResponse fileUploadResponse = new FileUploadResponse(filename, contentType, url);
        return new ResponseEntity<>(fileUploadResponse, HttpStatus.OK);

    }

    @GetMapping("/download/{filename}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String filename, HttpServletRequest httpServletRequest){
        Resource resource = fileStorageService.downloadFile(filename);

        //MediaType contentType = MediaType.IMAGE_JPEG;
        String mimeType;
        try{
            mimeType = httpServletRequest.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException e) {
            mimeType = MediaType.APPLICATION_OCTET_STREAM_VALUE;
        }
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(mimeType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename="+resource.getFilename())
                .body(resource);
    }
}
