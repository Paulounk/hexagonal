package com.lopes.hexagonal.config;

import com.lopes.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.lopes.hexagonal.adapters.out.UpdateCustomerAdapter;
import com.lopes.hexagonal.application.core.usecase.UpdateCustomerUseCase;
import com.lopes.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.lopes.hexagonal.application.ports.in.UpdateCustomerInputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCustomerConfig {

    @Bean
    public UpdateCustomerInputPort updateCustomerInputPort(
            FindCustomerByIdInputPort findCustomerByIdInputPort,
            FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
            UpdateCustomerAdapter updateCustomerAdapter
    ) {
        return new UpdateCustomerUseCase(findCustomerByIdInputPort, findAddressByZipCodeAdapter, updateCustomerAdapter);
    }

}