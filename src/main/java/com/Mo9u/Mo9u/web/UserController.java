package com.Mo9u.Mo9u.web;

import com.Mo9u.Mo9u.jwt.JwtTokenUtil;
import com.Mo9u.Mo9u.service.MessageService;
import com.Mo9u.Mo9u.service.UserService;
import com.Mo9u.Mo9u.web.dto.user.CheckIdDto;
import com.Mo9u.Mo9u.web.dto.HttpResponseDto;
import com.Mo9u.Mo9u.web.dto.user.SignUpDto;
import com.Mo9u.Mo9u.web.dto.user.UserLoginDto;
import java.util.Random;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final MessageService messageService;

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

    @PostMapping("/signUp/sendSMS")
    public ResponseEntity<HttpResponseDto> sendSMS(@RequestBody String phoneNumber) {

        Random rand  = new Random();
        String numStr = "";
        for(int i=0; i<4; i++) {
            String ran = Integer.toString(rand.nextInt(10));
            numStr+=ran;
        }

        System.out.println("수신자 번호 : " + phoneNumber);
        System.out.println("인증번호 : " + numStr);
        messageService.sendAuthMessage(phoneNumber,numStr);
        return ResponseEntity.status(HttpStatus.OK).body(new HttpResponseDto(200, numStr));
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody UserLoginDto loginRequest) {
        String loginId = userService.login(loginRequest);

        // 로그인 아이디나 비밀번호가 틀린 경우 global error return
        if(loginId == null) {
            return ResponseEntity.status(401).body(new HttpResponseDto(401, "로그인 아이디 또는 비밀번호가 틀렸습니다."));
        }

        // 로그인 성공 => Jwt Token 발급
        String secretKey = "catholicuniversitykorea";
        long expireTimeMs = 1000 * 60 * 60;     // Token 유효 시간 = 60분

        String jwtToken = JwtTokenUtil.createToken(loginId, secretKey, expireTimeMs);

        return ResponseEntity.status(HttpStatus.OK).body(new HttpResponseDto(200, jwtToken));
    }

}
