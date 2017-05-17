package com.now.eai.scsp.controller;

import java.security.cert.CertificateException;

import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;

import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.TrustStrategy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class HealthcheckController {

	@Value("${application.healthcheck.auth:Authorization}")
	private String healthCheckAuth = "Authorization";
	@Value("${application.healthcheck.appID: AppID }")
	private String healthCheckAppID = "AppID";
	@Value("${application.healthServiceUrlQa: healthServiceUrlQa }")
	private String healthServiceUrlQa = "healthServiceUrlQa";
	
	@RequestMapping(value = "/healthcheck", produces = { "application/json" })
	public String healthCheck() throws Exception {
		System.out.println(healthServiceUrlQa);
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/json");
		headers.set("Authorization", healthCheckAuth);
		headers.set("AppID", healthCheckAppID);		
		final HttpEntity<String> dealerRequest = new HttpEntity<String>(headers);		
		RestTemplate restTemplate = enableSSL();
		ResponseEntity<String> entity = restTemplate.exchange(healthServiceUrlQa, HttpMethod.GET,dealerRequest, String.class);		
		System.out.println(entity.getStatusCode());
		return entity.getBody().toString();
	}

	private RestTemplate enableSSL() throws Exception {
		TrustStrategy acceptingTrustStrategy = new TrustStrategy() {
			public boolean isTrusted(X509Certificate[] x509Certificates,
					String s) throws CertificateException {
				return true;
			}
		};
		SSLContext sslContext = org.apache.http.ssl.SSLContexts.custom()
				.loadTrustMaterial(null, acceptingTrustStrategy).build();
		SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(
				sslContext);
		CloseableHttpClient httpClient = HttpClients.custom()
				.setSSLSocketFactory(csf).build();
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		requestFactory.setHttpClient(httpClient);
		RestTemplate restTemplate = new RestTemplate(requestFactory);
		return restTemplate;
	}

}
