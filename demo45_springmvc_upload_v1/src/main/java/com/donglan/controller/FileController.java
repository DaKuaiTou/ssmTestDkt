package com.donglan.controller;

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
* @RestController注解相当于 @Controller + @ResponseBody 合在一起的意思
* 就不能返回jsp或者html的视图特面，也就是说，视图解析器就不会解析物理视图了，无法解析jsp/html面
*
* 步骤：
*   1. 需要配置文件解析器，将字节输入流解析成 multipartFile 对象
*   2. 在控制器方法中添加 MultipartFile 类型的形参
* */
@RestController
@RequestMapping("/file")
public class FileController {

    @RequestMapping("/upload")
    public String upload(MultipartFile upload, String desc, HttpSession session) throws IOException {

        FileOutputStream out = null;
        InputStream in = null;
        try {
            System.out.println("文件描述："+desc);// 输出文件描述
            // 获取目录路径
            ServletContext servletContext = session.getServletContext();
            // 项目的路径下转杯一个upload的目录，存储上传的文件
            String realPath = servletContext.getRealPath("upload");
            System.out.println("项目文件存储的路径："+realPath);
            File file = new File(realPath);
            if(!file.exists()){
                file.mkdirs();
            }

            // 获取文件名称
            String originalFilename = upload.getOriginalFilename();
            System.out.println("文件名称："+originalFilename);
            // 完成的文件路径
            File file1 = new File(file,originalFilename);
            // 通过文件输出流将客户端上传的文件输出到指定的目录
            out = new FileOutputStream(file1);
            // 客户端上传的输入流的获取
            in = upload.getInputStream();
            // 通过工具完成读写操作
            IOUtils.copy(in,out);

            return "success";

        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        } finally {
            in.close();
            out.close();
        }

    }
}
