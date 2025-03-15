package com.CultivaCursos.service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class SmsService {

    @Value("${twilio.account-sid}")
    private String accountSid;

    @Value("${twilio.auth-token}")
    private String authToken;

    @Value("${twilio.phone-number}")
    private String fromPhoneNumber;

    @PostConstruct
    public void initTwilio() {
        if (accountSid == null || authToken == null || fromPhoneNumber == null) {
            throw new IllegalStateException("As credenciais do Twilio não foram configuradas corretamente.");
        }
        Twilio.init(accountSid, authToken);
    }

    public void sendSms(String toPhoneNumber, String messageContent) {
        try {
            if (!isValidPhoneNumber(toPhoneNumber)) {
                throw new IllegalArgumentException("Número de telefone inválido.");
            }

            Message message = Message.creator(
                    new PhoneNumber(toPhoneNumber),
                    new PhoneNumber(fromPhoneNumber),
                    messageContent)
                .create();

            System.out.println("SMS enviado com sucesso! SID: " + message.getSid());
        } catch (Exception e) {
            System.err.println("Erro ao enviar SMS: " + e.getMessage());
        }
    }

    private boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber != null && phoneNumber.matches("^\\+?[1-9]\\d{1,14}$"); 
    }
}
