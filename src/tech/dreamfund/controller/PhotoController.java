package tech.dreamfund.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.dreamfund.model.Photo;
import tech.dreamfund.service.PhotoService;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by xiasu on 2017/6/24.
 */
@Controller
public class PhotoController {
    @Autowired
    private PhotoService photoService;

    @RequestMapping("/addPhoto")
    public String addPhoto(String photoName, int albumId, String imgBase, int lookIndex, HttpServletResponse response) {
        try {
            Photo photo=new Photo(photoName,albumId);
            photo.setImage(imgBase.getBytes());
            photoService.addPhoto(photo);
            String json="{\"isok\":\"true\",\"int\":\""+lookIndex+"\"}";
            response.getWriter().write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
