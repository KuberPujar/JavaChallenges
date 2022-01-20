package com.io;
import java.io.*;
import java.util.Random;
import java.util.Scanner;


// Write your code below.
//

class EncryptDecryptFile
{

	public String readEncryptionFile() {
		String str="";
		try {
			BufferedReader reader=new BufferedReader(new FileReader("D:\\ChallengeResults\\EncryptionFile.txt"));
			str=reader.readLine();
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return str;
	}

	public void writeDecryptionFile(String message) {
		try {
			BufferedWriter writer=new BufferedWriter(new FileWriter("D:\\ChallengeResults\\DecryptionFile.txt"));
			writer.write(message);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}

public class Solution {
    public static String filepath = "D:\\ChallengeResults\\";

    private static String generateString()
    {
        char[] chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890".toCharArray();
        StringBuilder generatedString = new StringBuilder(20);
        Random random = new Random();
        for (int i = 0; i < 40; i++) {
            char c = chars[random.nextInt(chars.length)];
            generatedString.append(c);
        }
        return generatedString.toString();
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String message = sc.nextLine();

        try{
            EncryptDecryptFile f = new EncryptDecryptFile ();
            String encryptFilename = Solution.filepath + "EncryptionFile.txt";
            String generatedString = generateString();
            BufferedWriter writer = new BufferedWriter(new FileWriter(encryptFilename));
            writer.write(generatedString);
            writer.flush();
            writer.close();

            if(f.readEncryptionFile().equals(generatedString))
            {
                f.writeDecryptionFile(message);

                String decryptFilename = Solution.filepath + "DecryptionFile.txt";
                BufferedReader reader = new BufferedReader(new FileReader(decryptFilename));
                String messageFromFile = reader.readLine();
                reader.close();

                System.out.println(messageFromFile);
            }
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }

    }

}