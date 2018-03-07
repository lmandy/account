package com.lmandy.utils;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.SecureRandom;

/**
 * Created by lmandy on 2017/11/10.
 */
public class AESUtil {
    /**
     * 生成二进制秘钥
     * @param password
     * @throws Exception
     */
    public static byte[] initKey(String password) throws Exception {
        //实例化秘钥生成器 使用AES算法
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        //初始化密钥生成器，AES要求密钥长度为128位、192位、256位
        keyGenerator.init(128,new SecureRandom(password.getBytes()));
        //生成密钥
        SecretKey secretKey = keyGenerator.generateKey();
        //获取二进制密钥编码形式
        byte[] encoded = secretKey.getEncoded();
        return encoded;
    }

    /**
     * 加密
     * @param content 待加密内容
     * @param password 用于加密的密码
     */
    public static byte[] encrypt(String content,String password) throws Exception {
        //获取秘钥
        byte[] keys = initKey(password);
        //转换秘钥
        Key secretKey = new SecretKeySpec(keys,"AES");
        //实例化密码器
        Cipher cipher = Cipher.getInstance("AES");
        //初始化，设置为加密模式
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        //加密
        byte[] bytes = cipher.doFinal(content.getBytes());
        return bytes;
    }

    /**
     * 解密
     * @param content 待解密数据
     * @param password 用于解密的密码
     * @return
     */
    public static byte[] dencrypt(byte[] content,String password) throws Exception {
        //获取秘钥
        byte[] keys = initKey(password);
        //转换秘钥
        Key key = new SecretKeySpec(keys,"AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE,key);
        byte[] bytes = cipher.doFinal(content);

        return bytes;
    }

    public static void main(String[] args) throws Exception {
//
//        //加密
//        byte[] bytes = encrypt("hello world", "123456");
//
//        //加密后的二进制数据无法转换成字符串 可以 转换成16进制
//        String content = parseByte2HexStr(bytes);
//        System.out.println("加密后内容："+content);
//        //解密  将16进制转化成2进制
        byte[] dencrypt = dencrypt(parseHexStr2Byte("C77500A4B4B63A4EC9ADCCA015A4987B"), "lmandy913");
        System.out.println("解密后数据:"+new String(dencrypt));
        System.out.println("----------------------------------------------------------------------------------------");
//        /**
//         * 如使用base64 需要引入包
//         * compile group: 'commons-codec', name: 'commons-codec', version: '1.10'
//         */
//
//        String result = Base64.encodeBase64String(bytes); // 或者是将二进制转换成base64
//        System.out.println("加密后："+result);
//        String s = new String(dencrypt(Base64.decodeBase64(result), "123456"));
//        System.out.println("解密后："+s);

    }

    /**将二进制转换成16进制
     * @param buf
     * @return
     */
    public static String parseByte2HexStr(byte buf[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }
    /**将16进制转换为二进制
     * @param hexStr
     * @return
     */
    public static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1)
            return null;
        byte[] result = new byte[hexStr.length()/2];
        for (int i = 0;i< hexStr.length()/2; i++) {
            int high = Integer.parseInt(hexStr.substring(i*2, i*2+1), 16);
            int low = Integer.parseInt(hexStr.substring(i*2+1, i*2+2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }

}
