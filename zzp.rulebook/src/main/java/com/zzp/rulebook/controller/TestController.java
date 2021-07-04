package com.zzp.rulebook.controller;

import com.deliveredtechnologies.rulebook.FactMap;
import com.deliveredtechnologies.rulebook.NameValueReferableMap;
import com.deliveredtechnologies.rulebook.model.RuleBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description test controller
 * @Author Garyzeng
 * @since 2021.07.04
 **/
@RestController
@RequestMapping(value = "test")
public class TestController {

    @Autowired
    private RuleBook ruleBook;

    @ResponseBody
    @RequestMapping(value = "test", method = RequestMethod.GET)
    public String test() {
        NameValueReferableMap<String> facts = new FactMap<String>();
        facts.setValue("hello", "Hello ");
        facts.setValue("world", "World");
        ruleBook.run(facts);
        ruleBook.getResult().ifPresent(System.out::println); //prints Hello World!
        return null;
    }

}
