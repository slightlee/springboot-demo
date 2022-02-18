package xjar.util;

import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.StandardPBEByteEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;

/**
 * Jasypt 加密类工具包
 */
public class JasyptUtils {

    private static final String PBEWITHMD5ANDDES = StandardPBEByteEncryptor.DEFAULT_ALGORITHM;

    private static final String PBEWITHHMACSHA512ANDAES_256 = "PBEWITHHMACSHA512ANDAES_256";


    /**
     * Jasypt加密
     * 加密方式 PBEWITHMD5ANDDES
     * @param password 加密秘钥
     * @param value    待加密值
     * @return 加密结果
     */
    public static String encryptPwdWithMd5(String password, String value) {
        // 创建加解密工具实例
        PooledPBEStringEncryptor encryptOr = new PooledPBEStringEncryptor();

        encryptOr.setConfig(cryptOr(password, PBEWITHMD5ANDDES));
        return encryptOr.encrypt(value);
    }

    /**
     * Jasypt解密
     * 加密方式 PBEWITHMD5ANDDES
     * @param password 加密秘钥
     * @param value    待解密密文
     * @return 解密结果
     */
    public static String decyptPwdWithMd5(String password, String value) {
        PooledPBEStringEncryptor encryptOr = new PooledPBEStringEncryptor();
        encryptOr.setConfig(cryptOr(password, PBEWITHMD5ANDDES));
        return encryptOr.decrypt(value);
    }

    /**
     * Jasypt加密
     * 加密方式 PBEWITHHMACSHA512ANDAES_256
     * @param password 加密秘钥
     * @param value    待加密密文
     * @Return:
     */
    public static String encryptPwdWithSha512(String password, String value) {
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        encryptor.setConfig(cryptOr(password, PBEWITHHMACSHA512ANDAES_256));
        return encryptor.encrypt(value);
    }

    /**
     * Jasypt解密
     * 加密方式 PBEWITHHMACSHA512ANDAES_256
     * @param password 加密秘钥
     * @param value    待解密密文
     * @Return:
     */
    public static String decyptPwdWithSha512(String password, String value) {
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        encryptor.setConfig(cryptOr(password, PBEWITHHMACSHA512ANDAES_256));
        return encryptor.decrypt(value);
    }


    /**
     * @Param: password 加密秘钥
     * @Param: algorithm 加密方式
     * @Return:
     */
    public static SimpleStringPBEConfig cryptOr(String password, String algorithm) {
        // 加解密配置
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword(password);
        config.setAlgorithm(algorithm);
        // 为减少配置文件的书写，以下都是 Jasyp 3.x 版本，配置文件默认配置
        config.setKeyObtentionIterations("1000");
        config.setPoolSize("1");
        config.setProviderName(null);
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setIvGeneratorClassName("org.jasypt.iv.RandomIvGenerator");
        config.setStringOutputType("base64");
        return config;
    }


    public static void main(String[] args) {

        System.out.println("-----采用MD5加密----");
        // 加密  PfuRBivbwOXrZlk2ZLNk/lWNjQJjXndQ
        System.out.println(encryptPwdWithMd5("ABCDEF", "123456"));
        System.out.println(encryptPwdWithMd5("ABCDEF", "root"));
        // 解密 123456
        System.out.println(decyptPwdWithMd5("ABCDEF", "PfuRBivbwOXrZlk2ZLNk/lWNjQJjXndQ"));

        System.out.println("-----采用SHA512加密----");

        // 加密  JqcfY6ZE6ah42VuphgL803bh1c0uW84Me1VDXdqg/yITQykgu9idqAzsWwp0l+jn
        System.out.println(encryptPwdWithSha512("ABCDEF", "123456"));
        System.out.println(encryptPwdWithSha512("ABCDEF", "root"));
        // 解密 123456
        System.out.println(decyptPwdWithSha512("ABCDEF", "JqcfY6ZE6ah42VuphgL803bh1c0uW84Me1VDXdqg/yITQykgu9idqAzsWwp0l+jn"));

    }
}
