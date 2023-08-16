package com.Mo9u.Mo9u.service;

import com.Mo9u.Mo9u.domain.User;
import com.Mo9u.Mo9u.repository.UserRepository;
import com.Mo9u.Mo9u.web.dto.user.SignUpDto;
import com.Mo9u.Mo9u.web.dto.user.UserLoginDto;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public String login(UserLoginDto loginDto) {

        User findUser = userRepository.findByLoginId(loginDto.getLoginId())
            .filter(u -> u.getLoginPassword().equals(loginDto.getLoginPassword()))
            .orElse(null);

        if (findUser == null) {
            return null;
        } else {
            return findUser.getLoginId();
        }
    }

    // 아이디 중복 확인
    public boolean checkLoginId(String loginId) {
        User findUser = userRepository.findByLoginId(loginId)
                .orElse(null);

        if (findUser == null) {
            return false;
        } else {
            System.out.println(findUser.getId());
            return true;
        }
    }

    // 회원가입
    public void signUp(SignUpDto signUpDto){
        userRepository.save(signUpDto.toEntity());
    }

    public User getUserByLoginId(String loginId) {
        Optional<User> byLoginId = userRepository.findByLoginId(loginId);
        return byLoginId.get();
    }
    public Long getUserIdByLoginId(String loginId) {
        Optional<User> byLoginId = userRepository.findByLoginId(loginId);
        return byLoginId.get().getId();
    }
}
