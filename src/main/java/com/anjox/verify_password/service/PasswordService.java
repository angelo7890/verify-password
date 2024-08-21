package com.anjox.verify_password.service;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class PasswordService {
    public List<String> passwordCheck(String password) {
        List<String> list = new ArrayList<String>();
         if (!(password != null && password.length() > 8)) {
             list.add("a senha tem que conter no minimo 8 caracteres");
         }
         if (!Pattern.matches(".*[A-Z].*", password)) {
             list.add("a senha tem que conter letra maiuscula");
         }
        if (!Pattern.matches(".*[a-z].*", password)) {
            list.add("a senha tem que conter letra minuscula");
        }
        if (!Pattern.matches(".*[0-9].*", password)) {
            list.add("a senha tem que conter numeros");
        }
        if (!Pattern.matches(".*[!@#$%^&*(),.?\\\":{}|<>].*", password)) {
            list.add("a senha tem que conter caracteres especiais");
        }
        return list;
    }
}
