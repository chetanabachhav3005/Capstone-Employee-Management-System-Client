package com.hdfc.capstone.employee.client;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;

import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.util.ResourceUtils;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Config {

	@Bean
	RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.requestFactory(()->validateSSL()).build();
		}
	
	private HttpComponentsClientHttpRequestFactory validateSSL() {
		
		String location="C:\\Users\\HPUSER\\Downloads\\capstone-employee-project\\capstone-employee-project\\src\\main\\resources\\capstoneemployee.jks";
		String pass="shreeom";
		SSLContext sslContext=null;
		try {
			sslContext=SSLContextBuilder.create().loadTrustMaterial(ResourceUtils.getFile(location),pass.toCharArray()).build();
		}catch(Exception e) {
			
		}
		SSLConnectionSocketFactory csf=new SSLConnectionSocketFactory(sslContext,new LocalHostnameVerifier());
		CloseableHttpClient httpClient=HttpClients.custom().setSSLSocketFactory(csf).build();
		HttpComponentsClientHttpRequestFactory requestFactory=new HttpComponentsClientHttpRequestFactory(httpClient);
		return requestFactory;
	}
	
	private class LocalHostnameVerifier implements HostnameVerifier{

		@Override
		public boolean verify(String s, SSLSession sslSession) {
			// TODO Auto-generated method stub
			return "localhost".equalsIgnoreCase(s)||"127.0.0.1".equals(s);
		}
		
	}
}
