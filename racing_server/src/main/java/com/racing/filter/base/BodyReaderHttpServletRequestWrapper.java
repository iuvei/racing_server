package com.racing.filter.base;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import com.racing.util.StreamUtil;


public class BodyReaderHttpServletRequestWrapper extends HttpServletRequestWrapper {

  private final byte[] body;

  private HttpServletRequest wrapped;

  public BodyReaderHttpServletRequestWrapper(HttpServletRequest wrapped) throws IOException {
    super(wrapped);
    this.wrapped = wrapped;
    body = StreamUtil.InputStreamTOByte(wrapped.getInputStream());
  }

  @Override
  public BufferedReader getReader() throws IOException {
    return new BufferedReader(new InputStreamReader(getInputStream()));
  }

  @Override
  public ServletInputStream getInputStream() throws IOException {
    final ByteArrayInputStream bais = new ByteArrayInputStream(body);
    // this.getInputStream().reset();
    return new ServletInputStream() {

      @Override
      public int read() throws IOException {
        return bais.read();
      }

      @Override
      public boolean isFinished() {
        try {
          return wrapped.getInputStream().isFinished();
        } catch (IOException e) {
          throw new IllegalStateException("requestFacade.nullRequest");
        }
      }

      @Override
      public boolean isReady() {
        try {
          return wrapped.getInputStream().isReady();
        } catch (IOException e) {
          throw new IllegalStateException("requestFacade.nullRequest");
        }
      }

      @Override
      public void setReadListener(ReadListener listener) {
        try {
          wrapped.getInputStream().setReadListener(listener);
        } catch (IOException e) {
          throw new IllegalStateException("requestFacade.nullRequest");
        }
      }

    };
  }

}
