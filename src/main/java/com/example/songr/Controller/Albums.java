package com.example.songr.Controller;
import com.example.songr.model.Album;
import com.example.songr.model.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;


@Controller
public class Albums {

    @Autowired
    AlbumRepository albumRepository;


    @GetMapping("/albums")
    public String albums(Model model){
        model.addAttribute("albums",albumRepository.findAll());
        return "album.html";
    }

//    @GetMapping("/addAlbum") // this should be a post, we are just adding it as get to run the function without using a form
//    public RedirectView addAlbum(){
//        Album alb1 = new Album("When I'm Gone","Eminem","17","4000","https://upload.wikimedia.org/wikipedia/en/b/b6/When_I%27m_Gone_%28Eminem_song%29.jpg");
//        Album alb3 = new Album("Tears Don't Fall","Bullet For My Valentine","5","2000","https://img.discogs.com/pbvGks9be9jAKsbp4TDqeYzX7z8=/fit-in/300x300/filters:strip_icc():format(jpeg):mode_rgb():quality(40)/discogs-images/R-6218779-1448854608-1072.jpeg.jpg");
//
//        albumRepository.save(alb1);
//        albumRepository.save(alb3);
//
//        return new RedirectView("/albums");
//    }

    @PostMapping("/newAlbum")
    public RedirectView addAlbum(@RequestBody MultiValueMap<String, String> formData){
        Album newAlbum = new Album(formData.get("title").get(0),formData.get("artist").get(0),formData.get("songCount").get(0),formData.get("length").get(0),formData.get("imgUrl").get(0));

        albumRepository.save(newAlbum);
        return new RedirectView("/albums");
    }
}
