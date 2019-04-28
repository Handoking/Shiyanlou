package com.shiyanlou.lesson2.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.shiyanlou.lesson2.domain.ResultObject;

/**
 * @author :Handoking
 * @date : 2019/4/26
 * 通过MultipartFile实现上传文件功能
 */

// 标注为返回json数据的controller，该类下的方法的URL前缀为/file
@RestController
@RequestMapping("file")
public class FileController {
    //文件保存路径
    private static String PATH = "/home/project";
    //上传文件
    @PostMapping("upload")
    public ResultObject upload(MultipartFile file){
        //如果文件为空，直接返回
        if (file.isEmpty()){
            return new ResultObject(-1,"file is empty");
        }
        //获取文件的名字
        String fileName = file.getOriginalFilename();
        //获取文件的额大小
       long fileSize = file.getSize();
       //创建文件
        File file1 = new File(PATH + fileName);
        try{
            //保存文件
            file.transferTo(file1);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResultObject(-1, "io exception");
        }catch(IllegalStateException e){
            e.printStackTrace();
            return new ResultObject(-1, "state exception");
        }
        return new ResultObject(null);
    }
}
