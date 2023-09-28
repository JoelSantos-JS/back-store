package com.joel.br.backstore.utils;

public class EmailUtils {


    public  static  String getEmailMessage(String nome , String host , String token) {
        return  "Olá " + nome + "!\n Your Account is  created on " + getVerfication(host,token);
    }
    public  static  String getEmailMessage(String nome , String host ) {
        return  "Olá " + nome + "!\n Your Account is  created on " + getVerfication(host);
    }

    private static String getVerfication(String host, String token) {
        return  host + "/users?token=" + token;
    }    private static String getVerfication(String host) {
        return  host + "/users?token=";
    }
}
