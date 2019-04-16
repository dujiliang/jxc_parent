package com.jxc.common.util;

import java.util.Random;

//验证码生成工具
public class ConfirmCodeUtil {

    //生成n位验证码
    public static String getNumberCode(int bit){
        int numCode = new Random().nextInt((int)Math.pow(10,bit));
        return String.format("%0" + bit + "d",numCode);
    }
}
