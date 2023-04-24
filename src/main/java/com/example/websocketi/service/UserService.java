package com.example.websocketi.service;


import com.example.websocketi.model.User;
import com.example.websocketi.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAll() {
        return this.userRepository.getAll();
    }

    public Optional<User> getUser(int userId) {
        return this.userRepository.getUser(userId);
    }

    public User save(User user) {
        if (user.getIdUser() == null)
            return this.userRepository.save(user);
        Optional<User> e = this.userRepository.getUser(user.getIdUser().intValue());
        if (!e.isPresent())
            return this.userRepository.save(user);
        return user;
    }

    public boolean deleteUser(int userId) {
        Boolean aBoolean = getUser(userId).<Boolean>map(user -> {
            this.userRepository.delete(user);
            return Boolean.valueOf(true);
        }).orElse(Boolean.valueOf(false));
        return aBoolean.booleanValue();
    }
}

