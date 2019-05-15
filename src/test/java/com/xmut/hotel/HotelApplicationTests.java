package com.xmut.hotel;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HotelApplicationTests {

    @Test
    public void contextLoads() {
        String dataString = "2018-09-11";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            System.out.println(sdf.parse(dataString));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
