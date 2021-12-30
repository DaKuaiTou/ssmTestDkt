package com.donglan.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.*;


/*
* 跨服务器完成文件上传
*   1. 使用Springmvc的方式获取客户端上传的文件
*   2。 使用跨服务器上传文件的API，将图片或文件上传到文件服务器
* */
@RestController
@RequestMapping("/file")
public class FileController {

    @RequestMapping("/upload")
    public String upload(MultipartFile upload, String desc) {

        System.out.println("文件的描述："+desc);

        try {
            // 获取文件的名称
            String originalFilename = upload.getOriginalFilename();
            // 获取上传文件的路径
            String uploadPath = "http://localhost:8081/upload/"+originalFilename;

            // 创建一个文件上传的客户端
            Client client = Client.create();
            // 建立与文件服务器的连接
            WebResource resource = client.resource(uploadPath);
            // 将客户端上传的文件  上传到文件服务器
            resource.put(upload.getBytes());

            return "success";

        } catch (IOException e) {
            e.printStackTrace();
            return "fail";
        }


    }
}
