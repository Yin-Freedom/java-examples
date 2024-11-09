package com.example.common.util;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.EnvironmentPBEConfig;

/**
 * jasypt加密工具
 * 用于根据password生成加密后的值
 * <p>
 * 使用方法：
 * 1.将值进行加密后在配置项中填写
 * 2.添加jasypt-spring-boot-starter依赖
 * 3.在配置文件中添加jasypt配置
 * 4.在项目启动时添加password参数
 *
 * @author freedom
 */
public class JasyptUtil {

    /**
     * PBE 算法
     */
    public static final String PBE_ALGORITHMS_MD5_DES = "PBEWITHMD5ANDDES";
    public static final String PBE_ALGORITHMS_MD5_TRIPLEDES = "PBEWITHMD5ANDTRIPLEDES";
    public static final String PBE_ALGORITHMS_SHA1_DESEDE = "PBEWITHSHA1ANDDESEDE";
    public static final String PBE_ALGORITHMS_SHA1_RC2_40 = "PBEWITHSHA1ANDRC2_40";

    private JasyptUtil() {
    }

    /**
     * Jasypt 加密
     *
     * @param encryptedStr 加密字符串
     * @param password     盐值
     * @return
     */
    public static String encrypt(String encryptedStr, String password) {
        return encrypt(encryptedStr, PBE_ALGORITHMS_MD5_DES, password);
    }

    /**
     * Jasypt 加密
     *
     * @param encryptedStr 加密字符串
     * @param algorithm    加密算法
     *                     PBE ALGORITHMS: [PBEWITHMD5ANDDES, PBEWITHMD5ANDTRIPLEDES, PBEWITHSHA1ANDDESEDE, PBEWITHSHA1ANDRC2_40]
     * @param password     盐值
     * @return
     */
    public static String encrypt(String encryptedStr, String algorithm, String password) {
        // StandardPBEStringEncryptor、StandardPBEBigDecimalEncryptor、StandardPBEBigIntegerEncryptor、StandardPBEByteEncryptor
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        EnvironmentPBEConfig config = new EnvironmentPBEConfig();

        // 指定加密算法
        config.setAlgorithm(algorithm);
        // 加密盐值
        config.setPassword(password);
        //config.setIvGeneratorClassName("org.jasypt.iv.NoIvGenerator");
        encryptor.setConfig(config);

        // 加密
        return encryptor.encrypt(encryptedStr);
    }

    /**
     * Jasypt 解密
     *
     * @param decryptStr 解密字符串
     * @param password   盐值
     * @return
     */
    public static String decrypt(String decryptStr, String password) {
        return decrypt(decryptStr, PBE_ALGORITHMS_MD5_DES, password);
    }

    /**
     * Jasypt 解密
     *
     * @param decryptStr 解密字符串
     * @param algorithm  指定解密算法：解密算法要与加密算法一一对应
     *                   PBE ALGORITHMS: [PBEWITHMD5ANDDES, PBEWITHMD5ANDTRIPLEDES, PBEWITHSHA1ANDDESEDE, PBEWITHSHA1ANDRC2_40]
     * @param password   盐值
     * @return
     */
    public static String decrypt(String decryptStr, String algorithm, String password) {
        // StandardPBEStringEncryptor、StandardPBEBigDecimalEncryptor、StandardPBEBigIntegerEncryptor、StandardPBEByteEncryptor
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        EnvironmentPBEConfig config = new EnvironmentPBEConfig();

        // 指定解密算法：解密算法要与加密算法一一对应
        config.setAlgorithm(algorithm);
        // 加密秘钥
        config.setPassword(password);
        //config.setIvGeneratorClassName("org.jasypt.iv.NoIvGenerator");
        encryptor.setConfig(config);

        // 解密
        return encryptor.decrypt(decryptStr);
    }

}
