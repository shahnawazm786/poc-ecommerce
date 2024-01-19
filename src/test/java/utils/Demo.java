package utils;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String encode=Base64EncodeAndDecode.encodeString("My name is shahnawaz");
		System.out.println(encode);
		String decode=Base64EncodeAndDecode.decodeString(encode);
		System.out.println(decode);

	}

}
