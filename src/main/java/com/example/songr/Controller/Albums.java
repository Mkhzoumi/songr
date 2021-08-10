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



        @PostMapping("/newAlbum")
    public RedirectView addAlbum(@ModelAttribute Album newAlbum){
        albumRepository.save(newAlbum);
        return new RedirectView("/albums");
    }


//    ======================================================================================================
    // another solution for posting by using @RequestBody


    //    @PostMapping("/newAlbum")
//    public RedirectView addAlbum(@RequestBody MultiValueMap<String, String> formData ){
////        Album newAlbum = new Album(formData.get("title").get(0),formData.get("artist").get(0),formData.get("songCount").get(0),formData.get("length").get(0),formData.get("imgUrl").get(0));
//
////        albumRepository.save(newAlbum);
//        return new RedirectView("/albums");
//    }
//    ======================================================================================================




}
