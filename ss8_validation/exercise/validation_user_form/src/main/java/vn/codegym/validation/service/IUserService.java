package vn.codegym.validation.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.validation.model.User;

public interface IUserService {
    Page<User> findAll(Pageable pageable);

    void create(User user);
}
