package com.example.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.cert.Certificate;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/client")
public class ClientResource {
	@Autowired
	RestTemplate restTemplate;

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public ResponseEntity<String> testMethod() {
		ResponseEntity<String> res = restTemplate.getForEntity("https://localhost:9999/server/test/",String.class);
		System.out.println(res.getBody());
		return ResponseEntity.status(HttpStatus.OK).body("client application!!");
	}

}
