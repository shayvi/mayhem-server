package mayhem.MayhemApi.controllers;//package mayhem.services;

import mayhem.MayhemApi.classesForMayhemApi.Song;
import mayhem.MayhemApi.services.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;


@Controller
@RequestMapping("mayhem")
public class SongController {
    @Autowired
    private SongService songService;


    @PostMapping("song")
    public ResponseEntity<Void> addSong(@RequestBody Song song, UriComponentsBuilder builder) {
        songService.add(song);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/article/{id}").buildAndExpand(song.getName()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }


}