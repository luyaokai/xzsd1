package com.xzsd.app.image;


import com.xzsd.app.util.AppResponse;
import com.xzsd.app.util.TencentCOS;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;


/** 图片上传
 * @author cairuifeng
 * @date 2020-04-10
 */
@RestController
@RequestMapping("/image")
public class ImageUploadController {

    @ResponseBody
    @PostMapping("uploadImage")
    public AppResponse upload(@RequestParam("imageFile") MultipartFile multipartFile)  {
        try {
            String fileName = multipartFile.getOriginalFilename();
            String prefix = fileName.substring(fileName.lastIndexOf("."));
            File file = File.createTempFile("imagesFile-" + System.currentTimeMillis(), prefix);
            multipartFile.transferTo(file);
            String fileUrl = TencentCOS.uploadfile(file, "images");
            file.deleteOnExit();
            return AppResponse.success("上传成功", fileUrl);
        } catch (IOException e) {
            return AppResponse.success(e.toString());
        }

    }

}



