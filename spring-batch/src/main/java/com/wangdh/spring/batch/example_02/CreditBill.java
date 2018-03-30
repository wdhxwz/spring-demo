package com.wangdh.spring.batch.example_02;

/**
 * 信用卡账单领域对象
 * Created by Administrator on 2018/3/30.
 */
public class CreditBill {
    /**
     * 账户id
     */
    private String accountId;
    /**
     * 持卡人姓名
     */
    private String name;
    /**
     * 消费时间
     */
    private String date;
    /**
     * 消费地址
     */
    private String address;
    /**
     * 消费金额
     */
    private double amount;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "CreditBill{" +
                "accountId='" + accountId + '\'' +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", address='" + address + '\'' +
                ", amount=" + amount +
                '}';
    }
}
