package com.serverless;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ResponderModel {
    private final String teamName = "dca";

    public String answer(String question) {
        String respuesta = "";
        if ("".equals(question)){
            respuesta = teamName;
        }

        Matcher resp1 = Pattern.compile(".*what is your name").matcher(question);
        if (resp1.matches()) {
            respuesta =  teamName;
        }

        Matcher resp2 = Pattern.compile(".*what is (\\d+) plus (\\d+)").matcher(question);
        if (resp2.matches()) {
            respuesta =  String.valueOf(Integer.parseInt(resp2.group(1)) + Integer.parseInt(resp2.group(2)));
        }

        Matcher resp3 = Pattern.compile(".*which of the following numbers is the largest: (\\d+), (\\d+)").matcher(question);
        if (resp3.matches()) {
            if (Integer.parseInt(resp3.group(1)) > Integer.parseInt(resp3.group(2))) {
                respuesta = String.valueOf(Integer.parseInt(resp3.group(1)));
            } else {
                respuesta = String.valueOf(Integer.parseInt(resp3.group(2)));
            }
        }

        Matcher resp4 = Pattern.compile(".*which of the following numbers is the largest: (\\d+), (\\d+)").matcher(question);

        //which of the following numbers is the largest: 892, 97, 70, 508

        Matcher sumMatcher = Pattern.compile(".*what is the sum of (\\d+) and (\\d+)").matcher(question);
        if (sumMatcher.matches()) {
            respuesta =  String.valueOf(Integer.parseInt(sumMatcher.group(1)) + Integer.parseInt(sumMatcher.group(2)));
        }
        return respuesta;
    }
}