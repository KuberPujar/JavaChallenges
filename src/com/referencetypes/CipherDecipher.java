package com.referencetypes;

public class CipherDecipher {

	public static void main(String[] args) {
		System.out.println(ciphering("See you then."));
		System.out.println(deciphering(".78E72T42U79Y42E69s3"));
	}

	// ?UOY*ERA*WOh*!Ih
	/**
	 * This method is used to cipher the message (normal) by following steps. Swap
	 * the cases of String - UpperCase letters to LowerCase letters and viceversa.
	 * Reverse the String Replace the spaces of string with a star character("*")
	 * Replace the characters in the even positions of the string Append any integer
	 * at the last in that String
	 * 
	 * @param normal
	 * @return the ciphered message
	 */
	@SuppressWarnings("deprecation")
	public static String ciphering(String normal) {
		// Write your code here
		char[] charArr = normal.toCharArray();
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < charArr.length; i++) {

			if (Character.isLowerCase(charArr[i])) {
				builder.append(Character.toUpperCase(charArr[i]));
			} else if (Character.isUpperCase(charArr[i])) {
				builder.append(Character.toLowerCase(charArr[i]));
			} else if (Character.isSpace(charArr[i])) {
				builder.append("*");
			}
			else
			{
				builder.append(charArr[i]);
			}
		}
		builder.reverse();
		StringBuilder asciBuilder = new StringBuilder();
		for (int i = 0; i < builder.toString().length(); i++) {
			if (i % 2 != 0) {
				asciBuilder.append(Integer.valueOf(builder.toString().charAt(i)));
			} else {
				asciBuilder.append(builder.toString().charAt(i));
			}
		}
		return asciBuilder.append(3).toString();
	}

	public static String deciphering(String ciphered) {
		// Write your code here
		String lastCharRemovedStr = ciphered.substring(0, ciphered.length() - 1);
		char[] str = lastCharRemovedStr.toCharArray();
		StringBuilder strBuilder = new StringBuilder();
		String num = "";
		for (char s : str) {
			if (Character.isDigit(s)) {
				num = num + s;
				int a = Integer.parseInt(num);
				char b = (char) a;
				if (num.length()>1) {
					if (num.length()==2) {
						strBuilder.append(String.valueOf(b).trim());
					} 
					else
					{
						strBuilder.append(String.valueOf(b).trim());
					}
				}
			} else if (Character.isAlphabetic(s)) {
				strBuilder.append(s);
				num = "";
			} else {
				num = "";
				strBuilder.append(s);
			}

		}
		strBuilder.reverse();
		char[] modified = strBuilder.toString().toCharArray();
		StringBuilder finalStr = new StringBuilder();
		for (char cd : modified) {
			if (Character.isLowerCase(cd)) {
				finalStr.append(Character.toUpperCase(cd));
			} else if (Character.isUpperCase(cd)) {
				finalStr.append(Character.toLowerCase(cd));
			} else {
				finalStr.append(cd);
			}
		}
		String returnStr = finalStr.toString();
		if (returnStr.contains("*")) {
			returnStr = returnStr.replace("*", " ");
		}
		return returnStr;
	}
}
