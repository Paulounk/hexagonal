package com.lopes.hexagonal.config;

import com.lopes.hexagonal.adapters.out.FindCustomerByIdAdapter;
import com.lopes.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import com.lopes.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindCustomerByIdConfig {

    @Bean
    public FindCustomerByIdInputPort findCustomerByIdInputPort(FindCustomerByIdAdapter findCustomerByIdAdapter) {
        return new FindCustomerByIdUseCase(findCustomerByIdAdapter);
    }
}