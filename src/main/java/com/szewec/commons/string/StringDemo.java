package com.szewec.commons.string;

import org.apache.commons.lang.StringUtils;

public class StringDemo {
    public static void main(String[] args) {
        String str1 = "01";
        String str2 = "02";
        String str3 = "";
        String str4 = null;
        System.out.println(StringUtils.equals(str1, str2));
        System.out.println(StringUtils.equals(str3, str4));
    }
}