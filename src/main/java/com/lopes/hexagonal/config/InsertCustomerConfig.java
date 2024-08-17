package com.lopes.hexagonal.config;

import com.lopes.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.lopes.hexagonal.adapters.out.InsertCustomerAdapter;
import com.lopes.hexagonal.adapters.out.SendCpfValidationAdapter;
import com.lopes.hexagonal.application.core.usecase.InsertCustomerUseCase;
import com.lopes.hexagonal.application.ports.in.InsertCustomerInputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustomerConfig {

    @Bean
    public InsertCustomerInputPort insertCustomerInputPort(FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
                                                         InsertCustomerAdapter insertCustomerAdapter,
                                                         SendCpfValidationAdapter sendCpfValidationAdapter) {
        return new InsertCustomerUseCase(findAddressByZipCodeAdapter,
                insertCustomerAdapter,
                sendCpfValidationAdapter);
    }
}
