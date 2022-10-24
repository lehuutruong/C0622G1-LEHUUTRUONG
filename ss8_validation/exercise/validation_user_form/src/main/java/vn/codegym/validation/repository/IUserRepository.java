package vn.codegym.validation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.validation.model.User;

public interface IUserRepository extends JpaRepository<User, Integer> {
}
