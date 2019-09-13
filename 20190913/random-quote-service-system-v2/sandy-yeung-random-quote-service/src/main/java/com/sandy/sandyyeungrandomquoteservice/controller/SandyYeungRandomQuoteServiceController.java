package com.sandy.sandyyeungrandomquoteservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Random;


@RestController
@RefreshScope
public class SandyYeungRandomQuoteServiceController {

    @Autowired
    private DiscoveryClient discoveryClient;

    private RestTemplate restTemplate = new RestTemplate();

    private Random random = new Random();

    @Value("${randomMagicEightBallServiceName}")
    private String randomMagicEightBallServiceName;

    @Value("${serviceProtocol}")
    private String serviceProtocol;

    @Value("${servicePath}")
    private String servicePath;

    @Value("${quotes}")
    private String quotesList;

    @RequestMapping(value = "/quote", method = RequestMethod.GET)
    public String getQuote() {
        String[] quotes = quotesList.split("\\^");

        String quote = quotes[random.nextInt(quotes.length)];

        return quote;
    }

    @RequestMapping(value = "/answerme", method = RequestMethod.GET)
    public String magicEightBallAnswer(){
        List<ServiceInstance> instances = discoveryClient.getInstances(randomMagicEightBallServiceName);

        String randomMagicEightBallUri = serviceProtocol + instances.get(0).getHost() + ":" + instances.get(0).getPort() + servicePath;

        String answer = restTemplate.getForObject(randomMagicEightBallUri, String.class);

        return answer;
    }
}
