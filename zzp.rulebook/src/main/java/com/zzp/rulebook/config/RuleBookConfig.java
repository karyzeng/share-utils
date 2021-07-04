package com.zzp.rulebook.config;

import com.deliveredtechnologies.rulebook.model.RuleBook;
import com.deliveredtechnologies.rulebook.spring.SpringAwareRuleBookRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description rulebook配置
 * @Author Garyzeng
 * @since 2021.07.04
 **/
@Configuration
public class RuleBookConfig {

    @Bean
    public RuleBook ruleBook() {
        RuleBook ruleBook = new SpringAwareRuleBookRunner("com.zzp.rulebook.example");
        return ruleBook;
    }

}
