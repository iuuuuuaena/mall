package com.tapd.utils;

/**
 * @Author jxd
 * @Date 2020-06-05  11:56
 * @Version 1.0
 */

import java.util.Random;

public class CodeUtil {
    public static String randomCode() {
        StringBuilder str = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            str.append(random.nextInt(10));
        }
        return str.toString();
    }
}
