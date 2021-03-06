package com.company.activemq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockController {

    @Autowired
    private JmsTemplate jmsTemplate;

    @GetMapping("/stock/{symbol}")
    public String getPrice(@PathVariable String symbol) {
        jmsTemplate.convertAndSend("StockQueue", symbol);
        return "You'll receive the stock value soon";
    }
}
