package com.zzp.rulebook.example;

import com.deliveredtechnologies.rulebook.annotation.*;
import com.deliveredtechnologies.rulebook.spring.RuleBean;
import com.zzp.rulebook.service.RulebookService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description WorldSpringRule
 * @Author Garyzeng
 * @since 2021.07.04
 **/
@RuleBean
@Rule(name = "HelloWorldRule", order = 2)
public class WorldSpringRule {

    @Autowired
    private RulebookService rulebookService;

    @Given("world")
    private String world;

    @Result
    private String result;

    @When
    public boolean when() {
        return world != null;
    }

    @Then
    public void then() {
        result = rulebookService.test(result, world);
    }

}
