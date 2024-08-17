package com.lopes.hexagonal.config;

import com.lopes.hexagonal.adapters.out.DeleteCustomerByIdAdapter;
import com.lopes.hexagonal.application.core.usecase.DeleteCustomerByIdUseCase;
import com.lopes.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import com.lopes.hexagonal.application.ports.in.DeleteCustomerByIdInputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteCustomerByIdConfig {

    @Bean
    public DeleteCustomerByIdInputPort deleteCustomerByIdInputPort(FindCustomerByIdUseCase findCustomerByIdUseCase,
                                                                 DeleteCustomerByIdAdapter deleteCustomerByIdAdapter
    ) {
        return new DeleteCustomerByIdUseCase(findCustomerByIdUseCase, deleteCustomerByIdAdapter);
    }
}
