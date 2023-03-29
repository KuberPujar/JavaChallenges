package com.customexception;

import java.util.Scanner;


class Validator {
    public static boolean validate(String message) {
        return message.matches("[A-Za-z0-9 ]+");
    }
}

class Encrypter
{
    public static String encryptMessage(String message) throws InvalidMessageException
    {
            if(Validator.validate(message))
            {
                StringBuilder str=new StringBuilder(message);
                str.reverse();
                return str.toString().toLowerCase();
            }
            else{
               throw new  InvalidMessageException(); 
            }
   
    }
}

class InvalidMessageException extends Exception
{
    static final long serialVersionUID =1L;
    String message="InvalidMessageException: Try again with valid message";
    @Override
    public String toString() {
        return message.toString();
    }
}

public class Solution {
    private static final Scanner INPUT_READER = new Scanner(System.in);
    
    public static void main(String[] args) {
        String message = INPUT_READER.nextLine();
        
        try {
            String encrypted_message = Encrypter.encryptMessage(message);
            if(! encrypted_message.startsWith("InvalidMessageException"))
                System.out.println(encrypted_message);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}