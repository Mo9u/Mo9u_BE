package com.Mo9u.Mo9u.service;

import lombok.RequiredArgsConstructor;
import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;

@RequiredArgsConstructor
@Service
public class MessageService {

    private String apiKey = "NCS3TVTAE27GVEDL";
    private String apiSecret = "RJW9XASGZR3K0D49W7KK3SQ5DOKT5DMA";
    private String fromNumber = "010-7330-9731";


    public void sendMessage(String toNumber, String randomNumber) {

        Message coolsms = new Message(apiKey, apiSecret);

        HashMap<String, String> params = new HashMap<String, String>();
        params.put("to", toNumber);
        params.put("from", fromNumber);
        params.put("type", "SMS");
        params.put("text", "[Mo9u] 인증번호 "+randomNumber+" 를 입력하세요.");
        params.put("app_version", "test app 1.2"); // application name and version

        try {
            JSONObject obj = (JSONObject) coolsms.send(params);
            System.out.println(obj.toString());
            System.out.println("!");
        } catch (CoolsmsException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCode());
            System.out.println("?");
        }
    }

}
