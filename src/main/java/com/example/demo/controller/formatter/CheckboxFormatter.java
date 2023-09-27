package com.example.demo.controller.formatter;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class CheckboxFormatter implements Formatter<Boolean> {


    @Override
    public Boolean parse(String text, Locale locale) throws ParseException {
        if(text == null) {
            return null;
        }
        return text.equals("on");
    }

    @Override
    public String print(Boolean object, Locale locale) {
        return object.toString();
    }
}
