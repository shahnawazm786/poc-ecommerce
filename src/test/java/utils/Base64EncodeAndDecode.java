package utils;

import org.apache.hc.client5.http.utils.Base64;

public class Base64EncodeAndDecode {
	public static String decodeString(String data) {
		byte[] decode=Base64.decodeBase64(data);
		return new String(decode); 
	}

	public static String encodeString(String data) {
		byte[] encode=Base64.encodeBase64(data.getBytes());
		return new String(encode);
	}
	
}
