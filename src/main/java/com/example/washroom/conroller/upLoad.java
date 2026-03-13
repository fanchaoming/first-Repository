package com.example.washroom.conroller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
public class upLoad {
    @RequestMapping(value = "/upLoad",method = RequestMethod.POST)
    public String up(String name, MultipartFile f, HttpServletRequest request)throws IOException {
//      ServletContext 代表整个 Web 应用的上下文环境，可以获取应用范围内的资源和参数。
//      以 Web 应用根目录为起点的虚拟路径（例如 /upload/）转换为文件系统上的真实路径（绝对路径）。
        String path=request.getServletContext().getRealPath("/upload/");
        System.out.println(path);
        System.out.println(f.getOriginalFilename());
        System.out.println(f.getContentType());
        saveFile(f,path);
        return "上传成功";
    }
    private void saveFile(MultipartFile f, String path) throws IOException {
        String filename = f.getOriginalFilename();
        if (filename == null || !isAllowedImageType(filename)) {
            throw new IllegalArgumentException("只允许上传图片文件（jpg, jpeg, png, gif）");
        }
        File dir=new File(path);
        if(!dir.exists()){
//            创建目录
            dir.mkdir();
        }
        File file=new File(path+f.getOriginalFilename());
        f.transferTo(file);//该方法可以将网络上传输过来的文件存储到参数路径上
    }
    // 检查是否为允许的图片类型
    private boolean isAllowedImageType(String filename) {
        String lowerName = filename.toLowerCase();
        return lowerName.endsWith(".jpg") || lowerName.endsWith(".jpeg") ||
                lowerName.endsWith(".png") || lowerName.endsWith(".gif");
    }
}
