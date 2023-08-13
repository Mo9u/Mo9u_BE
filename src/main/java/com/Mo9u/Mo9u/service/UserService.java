package com.Mo9u.Mo9u.service;

import com.Mo9u.Mo9u.domain.User;
import com.Mo9u.Mo9u.repository.UserRepository;
import com.Mo9u.Mo9u.web.dto.UserLoginDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Long login(UserLoginDto loginDto) {
        User findUser = userRepository.findByLoginId(loginDto.getLoginId())
            .filter(u -> u.getLoginPassword().equals(loginDto.getLoginPassword()))
            .orElse(null);

        if (findUser == null) {
            return null;
        } else {
            return findUser.getId();
        }
    }
}
