package com.gn.commom.filter;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class PasswordEncodingWrapper extends HttpServletRequestWrapper{
	public PasswordEncodingWrapper(HttpServletRequest request) {
		super(request);
	}
	@Override
	public String getParameter(String name) {
		// 데이터를 받아와서 암호화하는 과정
		String result = super.getParameter(name);
		
		
		if("user_pw".equals(name)) {
			String ori = super.getParameter(name);
			System.out.println("before : "+ori);
			String enc = getSHA512(ori);
			System.out.println("after : "+enc);
			result = enc;
		}
		return result;
	}
	
	// 매개변수로 문자열을 받아서 암호화된 문자열 리턴
	private String getSHA512(String oriStr) {
			MessageDigest md = null;
			try {
				// 적용할 알고리즘을 선택하여 인스턴스화 하는 것
				md = MessageDigest.getInstance("SHA-512");
			}catch(NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			// String을 byte 배열로 자름
			byte[] oriData = oriStr.getBytes();
			md.update(oriData);
			byte[] encryData = md.digest();
			return Base64.getEncoder().encodeToString(encryData);
	}
	

}
