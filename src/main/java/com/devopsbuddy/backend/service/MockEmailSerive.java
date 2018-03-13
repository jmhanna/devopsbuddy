package com.devopsbuddy.backend.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;

/**
 * Created by j_mha on 3/13/2018.
 */
public class MockEmailSerive extends AbstractEmailService {

    private static final Logger LOG = LoggerFactory.getLogger(MockEmailSerive.class);

    @Override
    public void sendGenericEmailMessage(SimpleMailMessage message){
        LOG.debug("Simulating an email service ...");
        LOG.info(message.toString());
        LOG.debug("Email Sent.");
    }
}
