package com.Mo9u.Mo9u.web;

import com.Mo9u.Mo9u.service.ManageService;
import com.Mo9u.Mo9u.service.UserService;
import com.Mo9u.Mo9u.web.dto.user.CheckIdDto;
import com.Mo9u.Mo9u.web.dto.HttpResponseDto;
import com.Mo9u.Mo9u.web.dto.user.SignUpDto;
import com.Mo9u.Mo9u.web.dto.user.UserLoginDto;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final ManageService manageService;

    @PostMapping("/user/login")
    public ResponseEntity<Object> userLogin(@Valid @RequestBody UserLoginDto loginDto,
        BindingResult bindingResult, HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bindingResult.getAllErrors());
        }

        Long userId = userService.login(loginDto);

        if (userId == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new HttpResponseDto(401, "아이디 또는 비밀번호가 맞지 않습니다"));
        }

        //로그인 성공로직
        HttpSession session = request.getSession(true);
        session.setAttribute(LoginSessionConst.USER_ID, userId);
        return ResponseEntity.status(HttpStatus.OK).body(new HttpResponseDto(200, session.getId()));
    }

    @PostMapping("/user/logout")
    public ResponseEntity<Object> userLogout(HttpServletRequest request) {

        HttpSession session = request.getSession(false);
        if (session == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new HttpResponseDto(400, "로그인 상태가 아닙니다"));
        }

        session.invalidate();
        return ResponseEntity.status(HttpStatus.OK).body(new HttpResponseDto(200, "로그아웃 완료"));

    }
    @PostMapping("/signUp/checkId")
    public ResponseEntity<Object> checkId(@Valid @RequestBody CheckIdDto checkIdDto, BindingResult bindingResult){
        System.out.println(checkIdDto.getLoginId());
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bindingResult);
        }
        if(userService.checkLoginId(checkIdDto.getLoginId()) == true){
            return ResponseEntity.status(HttpStatus.OK).body(new HttpResponseDto(200, "이미 존재하는 아이디입니다."));
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(new HttpResponseDto(200, "사용 가능한 아이디입니다."));
        }
    }

    @PostMapping("/signUp")
    public ResponseEntity<Object> checkId(@Valid @RequestBody SignUpDto signUpDto, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bindingResult);
        }
        userService.signUp(signUpDto);
        return ResponseEntity.status(HttpStatus.OK).body(new HttpResponseDto(200, "회원가입 성공"));

    }
}
