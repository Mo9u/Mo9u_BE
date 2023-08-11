package com.Mo9u.Mo9u.web;

import com.Mo9u.Mo9u.service.MessageService;
import com.Mo9u.Mo9u.web.dto.SubDetailResultDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
public class SignUpController {
    private final MessageService messageService;

    @PostMapping("/check/sendSMS")
    public ResponseEntity<SubDetailResultDto> sendSMS(@RequestBody String phoneNumber) {

        Random rand  = new Random();
        String numStr = "";
        for(int i=0; i<4; i++) {
            String ran = Integer.toString(rand.nextInt(10));
            numStr+=ran;
        }

        System.out.println("수신자 번호 : " + phoneNumber);
        System.out.println("인증번호 : " + numStr);
        messageService.sendMessage(phoneNumber,numStr);
        return ResponseEntity.status(HttpStatus.OK).body(new SubDetailResultDto(200, numStr));
    }
}
