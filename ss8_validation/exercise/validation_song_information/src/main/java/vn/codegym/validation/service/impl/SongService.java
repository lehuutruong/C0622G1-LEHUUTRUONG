package vn.codegym.validation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.validation.dto.SongDto;
import vn.codegym.validation.model.Song;
import vn.codegym.validation.repository.ISongDtoRepository;
import vn.codegym.validation.repository.ISongRepository;
import vn.codegym.validation.service.ISongService;

import java.util.Optional;

@Service
public class SongService implements ISongService {
    @Autowired
    private ISongRepository iSongRepository;
    @Autowired
    private ISongDtoRepository iSongDtoRepository;

    @Override
    public Page<Song> findAll(Pageable pageable) {
        return iSongRepository.findAll(pageable);
    }

    @Override
    public void create(Song song) {
        iSongRepository.save(song);
    }

    @Override
    public SongDto findById(int id) {
        SongDto songDto = iSongDtoRepository.findById(id).orElse(new SongDto());
        Optional<SongDto> optionalSong = iSongDtoRepository.findById(id);
        if ((optionalSong.isPresent())) {
            songDto = optionalSong.get();
        }
        return songDto;
    }

    @Override
    public void update(SongDto songDto) {
        iSongDtoRepository.save(songDto);
    }



}
