package vn.codegym.validation.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.validation.dto.SongDto;
import vn.codegym.validation.model.Song;

public interface ISongService {
    Page<Song> findAll(Pageable pageable);

    void create(Song song);

    SongDto findById(int id);

    void update(SongDto songDto);

}
