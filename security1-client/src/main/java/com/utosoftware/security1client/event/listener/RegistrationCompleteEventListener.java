package com.utosoftware.security1client.event.listener;

import com.utosoftware.security1client.entity.User;
import com.utosoftware.security1client.event.RegistrationCompleteEvent;
import com.utosoftware.security1client.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j
public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {
    private final UserService userService;

    public RegistrationCompleteEventListener(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event){
        //Create the Verification Token for the User with Link ( 링크를 가진 사용자용 검증된 토큰 만들기)
        User user = event.getUser();
        String token = UUID.randomUUID().toString();
        userService.saveVerificationTokenForUser(token,user);

        //Send Mail to user (사용자에게 메일보내기)
        String url = event.getApplicationUrl() + "verifyRegistration?token=" + token;

        //sendVerificationEmail()
        log.info("당신의 xxx 계정 확인을 위해 링크를 클릭하세요:{}",url);
    }
}
