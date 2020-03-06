package com.yyy.housingtransactions.util;

import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class AESUtil {

	private static Key key;
	private static String KEY_STR = "yuanguangxin";
	public static final String UTF_8 = "UTF-8";
	public static final String AES = "AES";

	// 静态初始化
	static {
		try {
			key = initKeyForAES(KEY_STR);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 得到key
	 * @param key
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	private static Key initKeyForAES(String key) throws NoSuchAlgorithmException {
        if (null == key || key.length() == 0) {
            throw new NullPointerException("key not is null");
        }
        SecretKeySpec key2 = null;
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
        random.setSeed(key.getBytes());
        try {
            KeyGenerator kgen = KeyGenerator.getInstance(AES);
            kgen.init(128, random);
            SecretKey secretKey = kgen.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            key2 = new SecretKeySpec(enCodeFormat, AES);
        } catch (NoSuchAlgorithmException ex) {
            throw new NoSuchAlgorithmException();
        }
        return key2;

    }
	
	
	/**
	 * 对源字符串加密,返回 BASE64编码后的加密字符串
	 * 
	 * @param source
	 *            源字符串,明文
	 * @return 密文字符串
	 */
	public static String encode(String source) {
		try {
			// 根据编码格式获取字节数组
			byte[] sourceBytes = source.getBytes(UTF_8);
			// DES 加密模式
			Cipher cipher = Cipher.getInstance(AES);
			cipher.init(Cipher.ENCRYPT_MODE, key);
			// 加密后的字节数组
			byte[] encryptSourceBytes = cipher.doFinal(sourceBytes);
			// Base64编码器
			Base64 base64Encoder = new Base64();

			return base64Encoder.encodeToString(encryptSourceBytes);
		} catch (Exception e) {
			// throw 也算是一种 return 路径
			throw new RuntimeException(e);
		}
	}

	/**
	 * 对本工具类 encode() 方法加密后的字符串进行解码/解密
	 * 
	 * @param encrypted
	 *            被加密过的字符串,即密文
	 * @return 明文字符串
	 */
	public static String decode(String encrypted) {
		// Base64解码器

		try {
			// 先进行base64解码
			byte[] cryptedBytes = Base64.decodeBase64(encrypted);
			// DES 解密模式
			Cipher cipher = Cipher.getInstance(AES);
			cipher.init(Cipher.DECRYPT_MODE, key);
			// 解码后的字节数组
			byte[] decryptStrBytes = cipher.doFinal(cryptedBytes);
			// 采用给定编码格式将字节数组变成字符串
			return new String(decryptStrBytes, UTF_8);
		} catch (Exception e) {
			// 这种形式确实适合处理工具类
			throw new RuntimeException(e);
		}
	}
}