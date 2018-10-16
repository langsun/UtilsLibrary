package com.sun.library;

import android.annotation.SuppressLint;
import android.text.TextUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * Created by sun on 17/12/14.
 */

public class VerificationUtil {

    /**
     * 验证Email
     *
     * @param email email地址，格式：zhangsan@sina.com，zhangsan@xxx.com.cn，xxx代表邮件服务商
     * @return 验证成功返回true，验证失败返回false
     */
    public static boolean checkEmail(String email) {
        String regex = "\\w+@\\w+\\.[a-z]+(\\.[a-z]+)?";
        return Pattern.matches(regex, email);
    }

    /**
     * 验证身份证号码
     *
     * @param idCard 居民身份证号码15位或18位，最后一位可能是数字或字母
     * @return 验证成功返回true，验证失败返回false
     */
    public static boolean checkIdCard(String idCard) {
        String regex = "[1-9]\\d{13,16}[a-zA-Z0-9]{1}";
        return Pattern.matches(regex, idCard);
    }


    /**
     * 验证固定电话号码
     *
     * @param phone 电话号码，格式：国家（地区）电话代码 + 区号（城市代码） + 电话号码，如：+8602085588447
     *              <p><b>国家（地区） 代码 ：</b>标识电话号码的国家（地区）的标准国家（地区）代码。它包含从 0 到 9 的一位或多位数字，
     *              数字之后是空格分隔的国家（地区）代码。</p>
     *              <p><b>区号（城市代码）：</b>这可能包含一个或多个从 0 到 9 的数字，地区或城市代码放在圆括号——
     *              对不使用地区或城市代码的国家（地区），则省略该组件。</p>
     *              <p><b>电话号码：</b>这包含从 0 到 9 的一个或多个数字 </p>
     * @return 验证成功返回true，验证失败返回false
     */
    public static boolean checkPhone(String phone) {
        String regex = "(\\+\\d+)?(\\d{3,4}\\-?)?\\d{7,8}$";
        return Pattern.matches(regex, phone);
    }

    /**
     * 验证整数（正整数和负整数）
     *
     * @param digit 一位或多位0-9之间的整数
     * @return 验证成功返回true，验证失败返回false
     */
    public static boolean checkDigit(String digit) {
        String regex = "\\-?[1-9]\\d+";
        return Pattern.matches(regex, digit);
    }

    /**
     * 验证整数和浮点数（正负整数和正负浮点数）
     *
     * @param decimals 一位或多位0-9之间的浮点数，如：1.23，233.30
     * @return 验证成功返回true，验证失败返回false
     */
    public static boolean checkDecimals(String decimals) {
        String regex = "\\-?[1-9]\\d+(\\.\\d+)?";
        return Pattern.matches(regex, decimals);
    }

    /**
     * 验证空白字符
     *
     * @param blankSpace 空白字符，包括：空格、\t、\n、\r、\f、\x0B
     * @return 验证成功返回true，验证失败返回false
     */
    public static boolean checkBlankSpace(String blankSpace) {
        String regex = "\\s+";
        return Pattern.matches(regex, blankSpace);
    }

    /**
     * 验证中文
     *
     * @param chinese 中文字符
     * @return 验证成功返回true，验证失败返回false
     */
    public static boolean checkChinese(String chinese) {
        String regex = "^[\u4E00-\u9FA5]+$";
        return Pattern.matches(regex, chinese);
    }

    /**
     * 验证日期（年月日）
     *
     * @param birthday 日期，格式：1992-09-03，或1992.09.03
     * @return 验证成功返回true，验证失败返回false
     */
    public static boolean checkBirthday(String birthday) {
        String regex = "[1-9]{4}([-./])\\d{1,2}\\1\\d{1,2}";
        return Pattern.matches(regex, birthday);
    }

    /**
     * 验证URL地址
     *
     * @param url 格式：http://blog.csdn.net:80/xyang81/article/details/7705960? 或 http://www.csdn.net:80
     * @return 验证成功返回true，验证失败返回false
     */
    public static boolean checkURL(String url) {
        String regex = "(https?://(w{3}\\.)?)?\\w+\\.\\w+(\\.[a-zA-Z]+)*(:\\d{1,5})?(/\\w*)*(\\??(.+=.*)?(&.+=.*)?)?";
        return Pattern.matches(regex, url);
    }

    /**
     * 匹配中国邮政编码
     *
     * @param postcode 邮政编码
     * @return 验证成功返回true，验证失败返回false
     */
    public static boolean checkPostcode(String postcode) {
        String regex = "[1-9]\\d{5}";
        return Pattern.matches(regex, postcode);
    }

    /**
     * 匹配IP地址(简单匹配，格式，如：192.168.1.1，127.0.0.1，没有匹配IP段的大小)
     *
     * @param ipAddress IPv4标准地址
     * @return 验证成功返回true，验证失败返回false
     */
    public static boolean checkIpAddress(String ipAddress) {
        String regex = "[1-9](\\d{1,2})?\\.(0|([1-9](\\d{1,2})?))\\.(0|([1-9](\\d{1,2})?))\\.(0|([1-9](\\d{1,2})?))";
        return Pattern.matches(regex, ipAddress);
    }

    /**
     * 验证身份证号码
     *
     * @param idCard 身份证号码
     * @return 验证结果
     */
    public static boolean checkIDCard(String idCard) {
        String regex = "\\d{18}|\\d{17}(\\d|X|x)";
        boolean result = false;
        if (Pattern.matches(regex, idCard)) {
            try {
                result = validateIDCard(idCard, "");
            } catch (Exception e) {
                result = false;
            }
        }
        return result;
    }

    /**
     * 全国省码
     */
    private static String ProvinceCode = "11x12x13x14x15x21x22x23x31x32x33x34x35x36x37x41x42x43x44x45x46x50x51x52x53x54x61x62x63x64x65x71x81x82";

    /**
     * 验证18位身份证号
     *
     * @param idCard 身份证号
     * @param sex    性别
     * @return 验证结果
     * @throws ParseException
     */
    @SuppressLint({"SimpleDateFormat", "DefaultLocale"})
    @SuppressWarnings("deprecation")
    private static boolean validateIDCard(String idCard, String sex) throws ParseException {

        //验证省码
        if (ProvinceCode.indexOf(idCard.substring(0, 2)) == -1) {
            return false;
        }

        //验证出生日期，只验证身份证号上的日期是否正确，不和实际的出生日期进行比较
        String yyyy = idCard.substring(6, 10);
        String mm = idCard.substring(10, 12);
        String dd = idCard.substring(12, 14);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        Date day = df.parse(yyyy + "-" + mm + "-" + dd);
        Date curr = df.parse(df.format(new Date()));// new Date()为获取当前系统时间
        String y = String.valueOf(day.getYear() + 1900);
        String m = String.valueOf(day.getMonth() + 1).length() == 1 ? "0" + String.valueOf(day.getMonth() + 1) : String.valueOf(day.getMonth() + 1);
        String d = String.valueOf(day.getDate()).length() == 1 ? "0" + String.valueOf(day.getDate()) : String.valueOf(day.getDate());
        if (!y.equals(yyyy) || !m.equals(mm) || !d.equals(dd) || day.compareTo(curr) > 0) {
            return false;
        }

        //验证性别
        if (sex.length() > 0) {
            String idSex = Integer.parseInt(idCard.substring(14, 17)) % 2 == 0 ? "男" : "女";
            if (idSex.equals(sex)) {
                return false;
            }
        }
        //验证校验码
        int[] wi = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
        String[] yi = {"1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2"};
        int sum = 0;
        for (int i = 0; i < 17; i++) {
            sum += Integer.parseInt(String.valueOf(idCard.charAt(i))) * wi[i];
        }
        String yString = yi[sum % 11];
        if (!String.valueOf(idCard.charAt(17)).toUpperCase().equals(yString)) {
            return false;
        }
        return true;
    }


    /**
     * 用正则判断是否是正确的手机号
     *
     * @return
     */
    public static boolean checkMobilePhoneNumber(String phoneNumber) {
        if (TextUtils.isEmpty(phoneNumber)) {
            return false;
        }

        final String telRegex = "[1]\\d{10}";//"[1]"代表第1位为数字1，"\\d{10}"代表后面是可以是0～9的数字，有10位。
        phoneNumber = phoneNumber.replaceAll(" ", "");
        return phoneNumber.matches(telRegex);
    }

    /**
     * 查看一个字符串是否可以转换为Double类型
     * @param str 字符串
     * @return true 可以; false 不可以
     */
    public static boolean checkStr2Dou(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * 查看一个字符串是否可以转换为int类型
     * @param str 字符串
     * @return true 可以; false 不可以
     */
    public static boolean checkStr2Int(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
