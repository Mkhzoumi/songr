package com.example.songr;

import com.example.songr.model.Album;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlbumTests {

    @Test
    public void testing(){
        Album testAlbum = new Album("test title","test artist",5,50,"test url");
        assertEquals("test artist",testAlbum.getArtist());
        assertEquals("test title",testAlbum.getTitle());

        testAlbum.setArtist("changed");
        assertEquals("changed",testAlbum.getArtist());

    }
}
