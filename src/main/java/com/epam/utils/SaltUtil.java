package com.epam.utils;

import org.apache.log4j.Logger;

import java.security.SecureRandom;

public class SaltUtil {

    private static final Logger LOG = Logger.getLogger(SaltUtil.class);

    public static String generateSalt() {
        StringBuilder builder = new StringBuilder();
        SecureRandom random = new SecureRandom();
        LOG.info("Generate random salt");
        boolean isUpperCase;
        char letter;
        for (int i = 0; i < 255; i++) {
            isUpperCase = random.nextBoolean();
            letter = (char) (random.nextInt(26) + 'a');
            builder.append(isUpperCase ? Character.toUpperCase(letter) : letter);
        }
        return builder.toString();
    }
}
