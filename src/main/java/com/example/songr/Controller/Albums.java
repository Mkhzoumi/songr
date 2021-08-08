package com.example.songr.Controller;
import com.example.songr.model.Album;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
public class Albums {

    @GetMapping("/albums")
    public static String albums(Model model){
        Album alb1 = new Album("When I'm Gone","Eminem",17,4000,"https://upload.wikimedia.org/wikipedia/en/b/b6/When_I%27m_Gone_%28Eminem_song%29.jpg");
        Album alb2 = new Album("Real Love","massari",14,3600,"https://img.discogs.com/NvXdabkx3RG1ewXZs91fkF7Ba-s=/fit-in/500x496/filters:strip_icc():format(webp):mode_rgb():quality(90)/discogs-images/R-3203996-1321482672.jpeg.jpg");
        Album alb3 = new Album("Tears Don't Fall","Bullet For My Valentine",5,2000,"https://img.discogs.com/pbvGks9be9jAKsbp4TDqeYzX7z8=/fit-in/300x300/filters:strip_icc():format(jpeg):mode_rgb():quality(40)/discogs-images/R-6218779-1448854608-1072.jpeg.jpg");

        List<Album> albumsArr = new ArrayList<>();
        albumsArr.add(alb1);
        albumsArr.add(alb2);
        albumsArr.add(alb3);

        model.addAttribute("albums",albumsArr);



        return "album.html";
    }

}
