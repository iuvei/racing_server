package com.racing.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

import javax.imageio.ImageIO;

public class StreamUtil {

  public static byte[] readBytes(Reader reader, String encoding) throws IOException {
    StringBuffer contenBuf = new StringBuffer();
    char[] buf = new char[1024];
    int len = -1;

    while ((len = reader.read(buf)) != -1) {
      String content = new String(buf, 0, len);
      contenBuf.append(content);
    }
    return StreamUtil.getBytes(contenBuf.toString(), encoding);
  }

  public static byte[] getBytes(char[] chars, String encoding) {
    Charset cs = Charset.forName("UTF-8");
    CharBuffer cb = CharBuffer.allocate(chars.length);
    cb.put(chars);
    cb.flip();
    ByteBuffer bb = cs.encode(cb);

    return bb.array();
  }

  public static byte[] getBytes(String content, String encoding) throws UnsupportedEncodingException {
    byte[] midbytes = content.getBytes(encoding);
    return midbytes;
  }

  public static byte[] InputStreamTOByte(InputStream in) throws IOException {

    ByteArrayOutputStream outStream = new ByteArrayOutputStream();
    byte[] data = new byte[1024];
    int count = -1;
    while ((count = in.read(data, 0, 1024)) != -1)
      outStream.write(data, 0, count);

    data = null;
    return outStream.toByteArray();
  }

  public static byte[] BufferedImageToByte(BufferedImage image, String format) throws IOException {
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    ImageIO.write(image, format, out);
    return out.toByteArray();
  }
}
