package com.add;

/**
 * @author 袁瑞龙
 */
public class Runing {

    /**
     * 二进制求和
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {
        //字符串反转
        StringBuilder sb1 = new StringBuilder(a);
        StringBuilder sb2 = new StringBuilder(b);
        a = sb1.reverse().toString();
        b = sb2.reverse().toString();
        //用户来记录相加之后的二进制结果
        StringBuilder result = new StringBuilder();
        //用来记录是否需要进位
        int carry = 0;
        //用来记录两个字符串中较短的那个字符串的长度
        int len = Math.min(a.length(), b.length());
        for (int i = 0; i <len; i++) {
            if (a.charAt(i) == '1'&& b.charAt(i) == '1') {
                if (carry == 1) {
                    result.append("1");
                }else {
                    result.append("0");
                }
                carry = 1;
            } else if (a.charAt(i) == '0'&& b.charAt(i) == '0') {
                if (carry == 1){
                    result.append("1");
                    carry = 0;
                }else {
                    result.append("0");
                }
            }else if (a.charAt(i) == '1'&& b.charAt(i) == '0') {
                if (carry == 1) {
                    result.append("0");
                }else {
                    result.append("1");
                    carry = 0;
                }
            }else if (a.charAt(i) == '0'&& b.charAt(i) == '1') {
                if (carry == 1) {
                    result.append("0");
                }else {
                    result.append("1");
                    carry = 0;
                }
            }
        }
        if (a.length() != b.length()) {
            //取出来较长字符串中剩余的部分
            String max = a.length() > b.length() ? a : b;
            for (int i = len; i < max.length(); i++) {
                if (max.charAt(i) == '1' && carry == 1) {
                    result.append("0");
                }else if (max.charAt(i) == '0' && carry == 1) {
                    result.append("1");
                    carry = 0;
                }else {
                    result.append(max.charAt(i));
                }
            }
        }
        //如果最后还有进位，就在最后加上一个1
        if (carry == 1) {
            result.append("1");
        }
        //最后再反转一次
        result.reverse();
        return result.toString();
    }
}
