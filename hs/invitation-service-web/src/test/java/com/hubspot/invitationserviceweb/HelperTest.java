package com.hubspot.invitationserviceweb;

import lombok.val;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class HelperTest {


    @Test
    public void helper1(){

        LocalDate localDate = LocalDate.parse("2017-04-22");

        LocalDate localDate2 = LocalDate.parse("2017-04-22");


        System.out.println(localDate.equals(localDate2));

    }

    @Test
    public void helper2(){

       Map<String,String> names  = new TreeMap<>();
       names.put("yasser","culon");
       names.put("alexis","mimado");
        names.put("yasser","dog");
       names.keySet().forEach(System.out::println);



    }

    @Test
    public void helper22(){

        Map<String, List<String>> names  = new TreeMap<>();
        val result = names.get("alexis");

        if (result==null){
            System.out.println("null fucker");
        }



    }


}
