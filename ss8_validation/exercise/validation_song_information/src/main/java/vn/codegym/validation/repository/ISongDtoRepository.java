package vn.codegym.validation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.validation.dto.SongDto;

public interface ISongDtoRepository extends JpaRepository<SongDto,Integer> {
}
