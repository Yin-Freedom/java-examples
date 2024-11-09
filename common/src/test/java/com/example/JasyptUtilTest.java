package com.example;

import com.example.common.util.JasyptUtil;
import org.junit.jupiter.api.Test;

/**
 * @author freedom
 */
public class JasyptUtilTest {

    private final String encryptedStr = "I am the string to be encrypted";
    private final String password = "salt";
    private final String algorithm = JasyptUtil.PBE_ALGORITHMS_MD5_DES;

    /**
     * 加密
     */
    @Test
    public void encrypt() {
        String str = JasyptUtil.encrypt(encryptedStr, algorithm, password);
        System.out.println("加密后的字符串：" + str);
        System.out.println("解密后的字符串：" + JasyptUtil.decrypt(str, algorithm, password));
    }

    /**
     * 解密
     */
    @Test
    public void decrypt() {
        String str = JasyptUtil.decrypt(encryptedStr, algorithm, password);
        System.out.println("解密后的字符串：" + JasyptUtil.decrypt(str, algorithm, password));
    }
}
