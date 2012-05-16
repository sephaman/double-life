package com.doublelife.doublelife.services.utils;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;



/**
 * Performs basic http functions.
 * @author Joseph McAleer
 *
 */
public class HttpHelper {

/**
 * @param url
 * @return
 */
public static String getHttpRequestBody(String url) {
	String returnValue = "";
	 HttpClient httpclient = new DefaultHttpClient();
     try {
    	 HttpGet httpget = new HttpGet(url);
    	 // Create a response handler
     ResponseHandler<String> responseHandler = new BasicResponseHandler();
     returnValue =  httpclient.execute(httpget, responseHandler);

 } catch (Exception ex) {
 }
	 finally {
     httpclient.getConnectionManager().shutdown();
 }
	 String[] parts = returnValue.split("\n");
	 return parts[1];
}

public static String getAFLHttpRequestBody(String url) {
	String returnValue = "";
	 HttpClient httpclient = new DefaultHttpClient();
     try {
    	 HttpGet httpget = new HttpGet(url);
    	 // Create a response handler
     ResponseHandler<String> responseHandler = new BasicResponseHandler();
     returnValue =  httpclient.execute(httpget, responseHandler);

 } catch (Exception ex) {
 }
	 finally {
     httpclient.getConnectionManager().shutdown();
 }
	 String[] parts = returnValue.split("\n");
	 return parts[0];
}
	
}
