package com.zzp.rulebook.example;

import com.deliveredtechnologies.rulebook.annotation.*;
import com.deliveredtechnologies.rulebook.spring.RuleBean;

/**
 * @Description HelloSpringRule
 * @Author Garyzeng
 * @since 2021.07.04
 **/
@RuleBean
@Rule(name = "HelloWorldRule", order = 1)
public class HelloSpringRule {

    @Given("hello")
    private String hello;

    @Result
    private String result;

    @When
    public boolean when() {
        return hello != null;
    }

    @Then
    public void then() {
        result = hello;
    }

}
