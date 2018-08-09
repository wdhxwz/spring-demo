package com.wangdh.lombok;

import lombok.SneakyThrows;
import lombok.Value;
import lombok.val;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

/**
 * @Auther: dw_wanghonghong
 * @Date: 2018/8/8 15:09
 * @Description:
 */
public class LombokApp {
    public static void main(String[] args){
        val user = new User(12,"123");
        System.out.println(user.toString());

        Student student = Student.builder().name("wangdh").build();
        System.out.println(student.toString());
    }

    @SneakyThrows()
    public void read() {
        InputStream inputStream = new FileInputStream("");
    }
}