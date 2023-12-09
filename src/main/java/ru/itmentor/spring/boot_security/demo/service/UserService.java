package ru.itmentor.spring.boot_security.demo.service;
import ru.itmentor.spring.boot_security.demo.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User addUser(User user);

    void delete(User user);

    Optional<User> findById(Long id);

    User editUser(User user);

    List<User> getAll();
}
