package com.dd.api.auth.providers;

import com.dd.api.auth.models.User;
import com.dd.api.auth.security.Salt;
import com.dd.api.util.TruncatedSystemTimeProvider;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.codec.binary.Base64;

import java.util.List;

@Service
public class AuthorizationService {

    private final AuthorizationRepository repository;

    @Autowired
    public AuthorizationService(AuthorizationRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public User login(String email, String password) {
        String prot = Salt.applyDoubleEndedSalt(password);
        return this.repository.findAll()
            .stream()
            .filter(p -> p.getEmail().equals(email))
            .filter(p -> p.getPassword().equals(Base64.encodeBase64String(prot.getBytes())))
            .findFirst()
            .orElse(null);
    }

    @Transactional
    public User createUser(User user) {
        // Check that the user isn't already registered
        List<User> control = this.repository.findAll()
                .stream()
                .filter(p -> p.getEmail().equals(user.getEmail()))
                .toList();

        if (!control.isEmpty()) {
            return null;
        }

        String prot = Salt.applyDoubleEndedSalt(user.getPassword());
        user.setPassword(Base64.encodeBase64String(prot.getBytes()));
        this.repository.save(user);
        return user;
    }

    @Transactional
    public boolean deleteUser(Long id) {
        this.repository.findById(id).ifPresent(p -> {
            p.setGhostedDate(new TruncatedSystemTimeProvider().provideTime());
            this.repository.save(p);
        });

        return true;
    }
}