package com.zzp.rulebook.service;

import org.springframework.stereotype.Component;

/**
 * @Description RulebookService
 * @Author Garyzeng
 * @since 2021.07.04
 **/
@Component
public class RulebookService {

    public String test(String hello, String world) {
        return hello + " " + world;
    }

}
