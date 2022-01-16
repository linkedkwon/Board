package com.board.service;

import com.board.domain.User;
import com.board.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void createUser(User user){
         userRepository.save(user);
    }

    public boolean signInUser(User user){
        Optional<User> entity = Optional.of(userRepository.findUserByUserId(user.getUserId())
                .orElseGet(() -> {
                    return new User("UNKNOWN");
                }));

        if(entity.get().getUserId().equals("UNKNOWN")
                || !entity.get().getPassword().equalsIgnoreCase(user.getPassword()))
            return false;

        return true;
    }

}