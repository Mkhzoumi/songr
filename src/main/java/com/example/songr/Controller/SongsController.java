package com.example.songr.Controller;


import com.example.songr.model.Album;
import com.example.songr.model.AlbumRepository;
import com.example.songr.model.Song;
import com.example.songr.model.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class SongsController {

    @Autowired
    SongRepository songRepository;
    @Autowired
    AlbumRepository albumRepository;


    @GetMapping("/songs")
    public String allSongs(Model model){
        model.addAttribute("songs",songRepository.findAll());

        return("allSongs.html");
    }


    @GetMapping("/albums/{id}")
    public String getSongs(@PathVariable("id") int id , Model model){
        model.addAttribute("album",albumRepository.findById(id).get());
        return("albumDetail.html");
    }


    @PostMapping("/addsong/{id}")
    public RedirectView addSong(@ModelAttribute Song song , @PathVariable("id") int id){
        song.setAlbum(albumRepository.findById(id).get());
        songRepository.save(song);
        return new RedirectView("/albums/{id}");
    }

}
