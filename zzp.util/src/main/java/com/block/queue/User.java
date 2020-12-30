package com.block.queue;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Description TODO
 * @Author karyzeng
 * @since 2019.05.18
 **/
public class User {

    private String name;

    private Integer age;

    private BigDecimal amount;

    private Date birthday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
