package com.lopes.hexagonal.adapters.in.consumer;

import com.lopes.hexagonal.adapters.in.consumer.mapper.CustomerMessageMapper;
import com.lopes.hexagonal.adapters.in.consumer.message.CustomerMessage;
import com.lopes.hexagonal.application.ports.in.UpdateCustomerInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ReceveidValidatedCpfConsumer{

    @Autowired
    private UpdateCustomerInputPort updateCustomerInputPort;

    @Autowired
    private CustomerMessageMapper customerMessageMapper;

    @KafkaListener(topics = "topic-in-cpf-validated", groupId = "lopes")
    public void receive(CustomerMessage customerMessage){
        var customer = customerMessageMapper.toCustomer(customerMessage);
        updateCustomerInputPort.update(customer, customerMessage.getZipCode());
    }
}
