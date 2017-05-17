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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class DealerController {

	@Value("${application.dealers.auth:Authorization}")
	private String dealersAuth = "Authorization";
	@Value("${application.dealers.appID: AppID }")
	private String dealersAppID = "AppID";
	@Value("${application.dealersUrlQa: dealersUrlQa }")
	private String dealersUrlQa = "dealersUrlQa";
	@Value("${application.dealers.app_key: dealersUrlQa }")
	private String app_key = "app_key"; 
	
	@RequestMapping(value = "/MBUSADealers", produces = { "application/json" })
	public String getAllDealers() throws Exception {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/json");
		headers.set("Authorization", dealersAuth);
		headers.set("AppID", dealersAppID);		
		headers.set("api_key", app_key);
		final HttpEntity<String> dealerRequest = new HttpEntity<String>(headers);		
		RestTemplate restTemplate = enableSSL();
				ResponseEntity<String> entity = restTemplate.exchange(dealersUrlQa+"/MBUSADealers", HttpMethod.GET,dealerRequest, String.class);		
		System.out.println(entity.getStatusCode());
		return entity.getBody().toString();
	}
	
	@RequestMapping(value = "/dealerinfo/zipcode={zip}", produces = { "application/json" })
	public String getDealersByValue(@PathVariable("zip") String zip) throws Exception {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/json");
		headers.set("Authorization", dealersAuth);
		headers.set("AppID", dealersAppID);		
		headers.set("api_key", app_key);
		final HttpEntity<String> dealerRequest = new HttpEntity<String>(headers);	
		
		String url = dealersUrlQa+ "/DealerLocator/zipcode="+zip;
		RestTemplate restTemplate = enableSSL();
				ResponseEntity<String> entity = restTemplate.exchange(url, HttpMethod.GET,dealerRequest, String.class);		
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