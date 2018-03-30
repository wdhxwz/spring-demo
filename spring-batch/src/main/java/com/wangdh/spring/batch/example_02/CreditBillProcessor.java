package com.wangdh.spring.batch.example_02;

import org.springframework.batch.item.ItemProcessor;

/**
 * Created by Administrator on 2018/3/30.
 */
public class CreditBillProcessor implements ItemProcessor<CreditBill,CreditBill>{
    @Override
    public CreditBill process(CreditBill creditBill) throws Exception {
        System.out.println(creditBill.toString());

        return creditBill;
    }
}
