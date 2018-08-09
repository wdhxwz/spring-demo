package com.wangdh.lombok;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

/**
 * @Auther: dw_wanghonghong
 * @Date: 2018/8/8 15:09
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer age;
    private String name;
}
