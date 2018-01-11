package org.hill.tx;

import org.hill.tx.entity.Customer;
import org.hill.tx.service.CustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(
                "org.hill.tx.config",
                "org.hill.tx.service"
        );

        CustomerService customerService = ctx.getBean(CustomerService.class);
        customerService.save(new Customer("Ahmed", "Hill"));

        customerService.find(1L);
    }
}
