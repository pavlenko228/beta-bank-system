package com.bank;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.bank.view", "com.bank.repository", "com.bank.service", "com.bank.controller"})
public class SpringConfig {
}
