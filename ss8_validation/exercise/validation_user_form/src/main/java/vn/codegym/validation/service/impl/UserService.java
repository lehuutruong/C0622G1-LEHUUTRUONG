package vn.codegym.validation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.validation.model.User;
import vn.codegym.validation.repository.IUserRepository;
import vn.codegym.validation.service.IUserService;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public Page<User> findAll(Pageable pageable) {
        return iUserRepository.findAll(pageable);
    }

    @Override
    public void create(User user) {
        iUserRepository.save(user);
    }
}
