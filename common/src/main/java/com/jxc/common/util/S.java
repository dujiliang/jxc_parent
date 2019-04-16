package com.jxc.common.util;

import java.math.BigInteger;

public class S {

    //是否为空（null或者去除头尾空格后为""）
    public static boolean isEmpty(String str){
        return (str == null || str.trim().equals(""))? true:false;
    }

    //是否长整形
    public static boolean isLong(String str) {
        if (str == null) {
            return false;
        }
        if (!str.matches("([+-]?[1-9][0-9]*)|0")) {
            return false;
        }

        BigInteger bi = new BigInteger(str);
        BigInteger minValue = new BigInteger(String.valueOf(Long.MIN_VALUE));
        BigInteger maxValue = new BigInteger(String.valueOf(Long.MAX_VALUE));
        if (bi.compareTo(minValue) < 0 || bi.compareTo(maxValue) > 0) {
            return false;
        }
        return true;
    }

    //是否整形
    public static boolean isInt(String str){
        if (str == null) {
            return false;
        }
        if (!str.matches("([+-]?[1-9][0-9]*)|0")) {
            return false;
        }

        BigInteger bi = new BigInteger(str);
        BigInteger minValue = new BigInteger(String.valueOf(Integer.MIN_VALUE));;
        BigInteger maxValue = new BigInteger(String.valueOf(Integer.MAX_VALUE));
        if (bi.compareTo(minValue) < 0 || bi.compareTo(maxValue) > 0) {
            return false;
        }
        return true;
    }

    //拼接
    public static String join(String... strArr){
        StringBuffer sb = new StringBuffer();
        for (String s : strArr) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static boolean isRegionCode(String str){
        return str != null && str.matches("[0-9]{2,4}");
    }

    public static boolean isPhone(String str){
        return str != null && str.matches("1[3-9][0-9]{9}");
    }

}
