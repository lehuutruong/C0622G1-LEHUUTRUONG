package vn.codegym.validation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.validation.model.Song;

public interface ISongRepository extends JpaRepository<Song, Integer> {
}
