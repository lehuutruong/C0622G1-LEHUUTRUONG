package vn.codegym.validation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import vn.codegym.validation.model.Song;

import vn.codegym.validation.repository.ISongRepository;
import vn.codegym.validation.service.ISongService;


@Service
public class SongService implements ISongService {
    @Autowired
    private ISongRepository iSongRepository;

    @Override
    public Page<Song> findAll(Pageable pageable) {
        return iSongRepository.findAll(pageable);
    }

    @Override
    public void create(Song song) {
        iSongRepository.save(song);
    }

    @Override
    public Song findById(int id) {
        return  iSongRepository.findById(id).orElse(new Song());
    }

    @Override
    public void update(Song song) {
        iSongRepository.save(song);
    }



}
