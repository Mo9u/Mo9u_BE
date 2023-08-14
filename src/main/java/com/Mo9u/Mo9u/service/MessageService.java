package com.Mo9u.Mo9u.service;

import lombok.RequiredArgsConstructor;
import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@RequiredArgsConstructor
@Service
public class MessageService {

    private final String apiKey = "NCS3TVTAE27GVEDL";
    private final String apiSecret = "RJW9XASGZR3K0D49W7KK3SQ5DOKT5DMA";

//    private final String fromNumber = "010-7148-7866";
    private final String fromNumber = "010-7330-9731";

    Message coolsms = new Message(apiKey, apiSecret);
    HashMap<String, String> params;

    public void sendAuthMessage(String toNumber, String randomNumber) {

        params = new HashMap<>();
        params.put("to", toNumber);
        params.put("from", fromNumber);
        params.put("type", "SMS");
        params.put("text", "[Mo9u] 인증번호 " + randomNumber + " 를 입력하세요.");
        params.put("app_version", "test app 1.2"); // application name and version

        try {
            JSONObject obj = coolsms.send(params);
            System.out.println(obj.toString());
        } catch (CoolsmsException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCode());
        }
    }

    public void sendNotificationMessage(String userTel, String userName, String date,
        String subName, String price) {
        params = new HashMap<>();
        params.put("to", userTel);
        params.put("from", fromNumber);
        params.put("type", "LMS");
        params.put("text",
            "[모두의 구독] 정기 구독서비스 결제 예정 알림\n" + userName + "님, 내일 " + date + "은 " + subName
                + "정기 결제일입니다." + "\n결제 예정 금액 : " + price);
        params.put("app_version", "test app 1.2"); // application name and version

        try {
            JSONObject obj = coolsms.send(params);
            System.out.println(obj.toString());
            System.out.println("!");
        } catch (CoolsmsException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCode());
            System.out.println("?");
        }
    }
}
