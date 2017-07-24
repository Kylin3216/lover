package tech.dreamfund.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import tech.dreamfund.model.Account;
import tech.dreamfund.model.Album;
import tech.dreamfund.model.Photo;
import tech.dreamfund.service.AlbumService;
import tech.dreamfund.util.RequestString;

import java.util.*;

/**
 * Created by xiasu on 2017/6/24.
 */
@Controller
@SessionAttributes({"account"})
public class AlbumController {
    @Autowired
    private AlbumService albumService;
    @RequestMapping("/addAlbum")
    public String addAlbum(Album album, ModelMap map) {
        Account account = (Account) map.get("account");
        album.setAccountId(account.getId());
        album.setCreateTime(new Date());
        albumService.createAlbum(album);
        return "redirect:/album";
    }

    @RequestMapping("/album")
    public String album(ModelMap map) {
        Account account = (Account) map.get("account");
        if (account == null || account.getId() == 0) {
            return "redirect:/index";
        }
        List<Album> albumList = albumService.queryAllAlbum();
        Map<Album,String> m=new TreeMap<>();
        for (Album album:albumList){
            if (album.getPhotos().size()>0){
                m.put(album,new String(album.getPhotos().get(0).getImage()));
            }else {
                m.put(album,null);
            }
        }
        Set<Map.Entry<Album,String>> set=m.entrySet();
        map.put("set", set);
        map.put("nav","album");
        return "album";
    }
}
