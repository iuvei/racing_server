package com.racing.filter;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.racing.constant.APIRequestHeaderConstant;
import com.racing.model.po.Manager;
import com.racing.model.po.User;
import com.racing.model.repo.ManagerRepo;
import com.racing.model.repo.UserRepo;
import com.racing.util.AccessKeyUtil;
import com.racing.util.EncryptUtil;
import com.racing.util.ListUtil;
import com.racing.util.LoginStatusSaveUtil;
import com.racing.util.ServeltRequestUtil;

import jodd.util.StringUtil;

@Component
@WebFilter(filterName = "checkAndTransformLoginStatusFilter", urlPatterns = "/*")
public class Filter2_CheckAndTransformLoginStatusFilter implements Filter {

	private static Logger LOGGER = LoggerFactory.getLogger(Filter2_CheckAndTransformLoginStatusFilter.class);

	@Autowired
	private ManagerRepo managerRepo;

	@Autowired
	private UserRepo userRepo;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		LOGGER.info("init CheckAndTransformLoginStatusFilter!");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		String requestURI = httpRequest.getRequestURI();
		
		if(requestURI.contains("/racing/web")){
			chain.doFilter(httpRequest, httpResponse);
			return;
		}
		
		if (httpRequest.getMethod().equalsIgnoreCase("OPTIONS")) {
			chain.doFilter(httpRequest, httpResponse);
			return;
		}
		
		LOGGER.info("request URI is :" + requestURI);
		if (!requestURI.contains(".") && !requestURI.contains("login")) {

			boolean isManagerRquest = requestURI.startsWith("/manager");

			String requestAccessKey = httpRequest.getHeader(APIRequestHeaderConstant.ACCESSKEY);

			if (StringUtil.isEmpty(requestAccessKey)) {
				this.setSignErrorResponse(httpResponse, httpRequest);
				return;
			}

			boolean isManager = AccessKeyUtil.checkAccessKeyIsManager(requestAccessKey);

			if (isManagerRquest != isManager) {
				this.setSignErrorResponse(httpResponse, httpRequest);
				return;
			}

			Integer loginId = null;
			boolean isWebUser = true;
			boolean isClientUser = false;
			String securityKey = "";
			String accessKey = AccessKeyUtil.getAccessKey(requestAccessKey);
			if (isManager) {
				Manager manager = managerRepo.getByAccessKey(accessKey);
				if (manager != null && manager.getIsEnable() && manager.getWebOutTime().after(new Date())) {
					securityKey = manager.getSecurityKey();
					loginId = manager.getId();
				}
			} else {
				if (AccessKeyUtil.checkAccessKeyIsWebUser(requestAccessKey)) {
					User user = userRepo.getByWebAccessKey(accessKey);
					if (user != null && user.getIsEnable() && user.getWebOutTime().after(new Date())) {
						securityKey = user.getWebSecurityKey();
						isWebUser = true;
						isClientUser = false;
						loginId = user.getId();
					}
				} else {
					String clientSN = httpRequest.getHeader(APIRequestHeaderConstant.CLIENT);
					User user = userRepo.getByClientAccessKey(accessKey);
					if (user != null && user.getIsEnable()
							&& user.getIsEnable() && StringUtil.isNotEmpty(clientSN)
							&& user.getClientIsEnable()
							&& user.getClientExpireDate().after(new Date())
							&& user.getClientSn().equals(clientSN)
							&& user.getClientOutTime().after(new Date())) {
						securityKey = user.getClientSecurityKey();
						isWebUser = false;
						isClientUser = true;
						loginId = user.getId();
					}
				}
			}

			if (StringUtil.isEmpty(securityKey)) {
				this.setSignErrorResponse(httpResponse, httpRequest);
				return;
			}

			if (!this.checkSign(httpRequest, requestURI, securityKey)) {
				this.setSignErrorResponse(httpResponse, httpRequest);
				return;
			} else {
				if (isManager) {
					LoginStatusSaveUtil.setManagerLoginInfo(loginId);
				} else if (isWebUser) {
					LoginStatusSaveUtil.setUserWebLoginInfo(loginId);
				} else if (isClientUser) {
					LoginStatusSaveUtil.setUserClientLoginInfo(loginId);
				}
			}
		}
		chain.doFilter(httpRequest, httpResponse);

	}

	@Override
	public void destroy() {
		LOGGER.info("destroy CheckAndTransformLoginStatusFilter!");
	}

	/**
	 * 设置错误签名信息
	 * 
	 * @param httpResponse
	 * @throws IOException
	 */
	private void setSignErrorResponse(HttpServletResponse httpResponse, HttpServletRequest httpRequest) throws IOException {
//		httpResponse.setStatus(HttpStatus.OK.value());
//		httpResponse.setContentType("application/json;charset=UTF-8");
//		PrintWriter out = null;  
//	    try {  
//	        out = httpResponse.getWriter();  
//	        out.append(JsonUtils.toJsonHasNullKey(ApiResult.createNoLoginReuslt()));  
//	    } catch (IOException e) {  
//	        e.printStackTrace();  
//	    } finally {  
//	        if (out != null) {  
//	            out.close();  
//	        }  
//	    }  
		try {
			httpRequest.getRequestDispatcher("/nologin").forward(httpRequest,httpResponse);
		} catch (ServletException e) {
			LOGGER.error("RequestDispatcher nologin has error", e);
		}  
        // 必须加返回，否则报错  
        return ; 
	}

	private boolean checkSign(HttpServletRequest httpRequest, String requestURI, String securityKey) {
		String requestSign = httpRequest.getHeader(APIRequestHeaderConstant.AUTHORIZATION);
		LOGGER.debug("前端传过来的Sign串为：" + requestSign);
		Map<String, String> requestQueryString = this.getRequestQueryStringData(httpRequest);
		String requestMethod = httpRequest.getMethod();
		String valueStr = "";
		if (requestMethod.equalsIgnoreCase("POST") || requestMethod.equalsIgnoreCase("PUT")) {
			String requestBody = ServeltRequestUtil.getRequestJsonString(httpRequest);
			if (StringUtil.isEmpty(requestBody)) {
				requestBody = "";
			}
			requestQueryString.put("requestBody", requestBody);
		}
		valueStr = ListUtil.sortMapParameterValueStr(requestQueryString);

		String preSign = requestURI + valueStr + securityKey;
		LOGGER.debug("加密前的串为：" + preSign);
		String sign = EncryptUtil.sha1UpperCase(preSign);
		LOGGER.debug("加密后的串为：" + sign);
		return sign.equals(requestSign);
	}

	private Map<String, String> getRequestQueryStringData(ServletRequest request) {
		Map<String, String> dataMap = new HashMap<String, String>();
		Map<String, String[]> urlData = request.getParameterMap();
		for (String key : urlData.keySet()) {
			dataMap.put(key, urlData.get(key)[0]);
		}
		return dataMap;
	}

}
