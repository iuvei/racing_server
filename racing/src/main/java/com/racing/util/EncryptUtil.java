package com.racing.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jodd.util.StringUtil;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * 加密算法
 * 
 * @author leon
 *
 */
@SuppressWarnings("restriction")
public class EncryptUtil {
  private static Logger logger = LoggerFactory.getLogger(EncryptUtil.class);

  /**
   * Used building output as Hex
   */
  private static final char[] DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

  /**
   * 对字符串进行MD5加密(默认UTF8)
   * 
   * @param text 明文
   * 
   * @return 密文 小写
   */
  public static String md5(String text) {
    return EncryptUtil.md5(text, "UTF-8");
  }

  /**
   * 对字符串进行MD5加密(默认UTF8)
   * 
   * @param text 明文
   * 
   * @return 密文 大写
   */
  public static String md5UpperCase(String text) {
    return EncryptUtil.md5(text).toUpperCase();
  }


  /**
   * 对字符串进行SHA-1加密(默认UTF8)
   * 
   * @param text 明文
   * 
   * @return 密文 小写
   */
  public static String sha1(String text) {
    return EncryptUtil.sha1(text, "UTF-8");
  }

  /**
   * 对字符串进行SHA-1加密(默认UTF8)
   * 
   * @param text 明文
   * 
   * @return 密文 大写
   */
  public static String sha1UpperCase(String text) {
    return EncryptUtil.sha1(text).toUpperCase();
  }


  /**
   * 对字符串进行MD5加密
   * 
   * @param text明文
   * 
   * @param charsetname 编码集(为空时，默认UTF-8)
   * 
   * @return 密文
   */
  public static String md5(String text, String charsetname) {
    if (charsetname == null || "".equals(charsetname)) {
      charsetname = "UTF-8";
    }
    MessageDigest msgDigest = null;

    try {
      msgDigest = MessageDigest.getInstance("MD5");
    } catch (NoSuchAlgorithmException e) {
      throw new IllegalStateException("System doesn't support MD5 algorithm.");
    }

    try {
      msgDigest.update(text.getBytes(charsetname));

    } catch (UnsupportedEncodingException e) {

      throw new IllegalStateException("System doesn't support your  EncodingException.");

    }

    byte[] bytes = msgDigest.digest();

    String md5Str = new String(encodeHex(bytes));

    return md5Str;
  }


  /**
   * 对字符串进行SHA-1加密
   * 
   * @param text 明文
   * @param charsetname 编码集(为空时，默认UTF-8)
   * 
   * @return 密文
   */
  public static String sha1(String text, String charsetname) {
    if (charsetname == null || "".equals(charsetname)) {
      charsetname = "UTF-8";
    }
    MessageDigest msgDigest = null;

    try {
      msgDigest = MessageDigest.getInstance("SHA-1");
    } catch (NoSuchAlgorithmException e) {
      throw new IllegalStateException("System doesn't support SHA-1 algorithm.");
    }

    try {
      msgDigest.update(text.getBytes(charsetname));

    } catch (UnsupportedEncodingException e) {

      throw new IllegalStateException("System doesn't support your  EncodingException.");

    }
    byte[] bytes = msgDigest.digest();
    String sha1Str = new String(encodeHex(bytes));
    return sha1Str;
  }

  private static char[] encodeHex(byte[] data) {

    int l = data.length;

    char[] out = new char[l << 1];

    // two characters form the hex value.
    for (int i = 0, j = 0; i < l; i++) {
      out[j++] = DIGITS[(0xF0 & data[i]) >>> 4];
      out[j++] = DIGITS[0x0F & data[i]];
    }

    return out;
  }

  /**
   * AES加密
   * 
   * @param content 待加密的内容
   * @param encryptKey 加密密钥
   * @return 加密后的byte[]
   * @throws Exception
   */
  public static byte[] aesEncryptToBytes(String content, String encryptKey) throws Exception {
    KeyGenerator kgen = KeyGenerator.getInstance("AES");
    SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
    secureRandom.setSeed(encryptKey.getBytes());
    kgen.init(128, secureRandom);
    Cipher cipher = Cipher.getInstance("AES");
    cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(kgen.generateKey().getEncoded(), "AES"));
    return cipher.doFinal(content.getBytes("UTF-8"));
  }

  /**
   * AES解密
   * 
   * @param encryptBytes 待解密的byte[]
   * @param decryptKey 解密密钥
   * @return 解密后的String
   * @throws Exception
   */
  public static String aesDecryptByBytes(byte[] encryptBytes, String decryptKey) throws Exception {
    KeyGenerator kgen = KeyGenerator.getInstance("AES");
    SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
    secureRandom.setSeed(decryptKey.getBytes());
    kgen.init(128, secureRandom);
    Cipher cipher = Cipher.getInstance("AES");
    cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(kgen.generateKey().getEncoded(), "AES"));
    byte[] decryptBytes = cipher.doFinal(encryptBytes);
    return new String(decryptBytes, "UTF-8");
  }

  /**
   * base 64 encode
   * 
   * @param bytes 待编码的byte[]
   * @return 编码后的base 64 code
   */
  public static String base64Encode(byte[] bytes) {
    return new BASE64Encoder().encode(bytes).replaceAll("\n", "").replaceAll("\r", "").replaceAll("\r\n", "");
  }

  /**
   * base64 encode
   * 
   * @param content 待编码的String
   * @return 编码后的base64 code
   */
  public static String base64Encode(String content) {
    byte[] strByte = null;
    if (StringUtil.isEmpty(content)) {
      return content;
    } else {
      try {
        strByte = content.getBytes("UTF-8");
      } catch (UnsupportedEncodingException e) {
        logger.error("", e);
      }
    }
    return new BASE64Encoder().encode(strByte);
  }

  /**
   * base 64 decode
   * 
   * @param base64Code 待解码的base 64 code
   * @return 解码后的byte[]
   * @throws Exception
   */
  public static byte[] base64Decode(String base64Code) throws Exception {
    return StringUtil.isEmpty(base64Code) ? null : new BASE64Decoder().decodeBuffer(base64Code);
  }

  /**
   * AES加密为base64 code
   * 
   * @param content 待加密的内容
   * @param encryptKey 加密密钥
   * @return 加密后的base 64 code
   * @throws Exception
   */
  public static String aesEncrypt(String content, String encryptKey) throws Exception {
    return base64Encode(aesEncryptToBytes(content, encryptKey));
  }

  /**
   * 将base64 code AES解密
   * 
   * @param encryptStr 待解密的base 64 code
   * @param decryptKey 解密密钥
   * @return 解密后的string
   * @throws Exception
   */
  public static String aesDecrypt(String encryptStr, String decryptKey) {
    if (StringUtil.isEmpty(encryptStr)) {
      return null;
    } else {
      String decodeStr = null;;
      try {
        decodeStr = aesDecryptByBytes(base64Decode(encryptStr), decryptKey);
      } catch (Exception e) {
        throw new RuntimeException("base64 code AES解密 出错");
      }
      return decodeStr;
    }
  }

  public static void main(String[] args) {
    System.out.println(md5UpperCase("12345678"));
  }
}
