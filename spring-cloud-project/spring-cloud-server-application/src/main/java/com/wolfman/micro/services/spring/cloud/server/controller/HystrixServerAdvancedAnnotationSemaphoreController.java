package com.wolfman.micro.services.spring.cloud.server.controller;


import com.wolfman.micro.services.spring.cloud.server.annotation.CircuitBreaker;
import com.wolfman.micro.services.spring.cloud.server.annotation.SemaphoreCircuitBreaker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 *  高级版本 + 注解
 */
@RestController
@RequestMapping("/hystrix/advanced/annotation/semaphore")
public class HystrixServerAdvancedAnnotationSemaphoreController {

    private final static Random random = new Random();

    /**
     * 高级版本 + 注解（信号量）
     * @param message
     * @return
     * @throws Exception
     */
    @GetMapping("/say")
    @SemaphoreCircuitBreaker(1)
    public String say(@RequestParam String message) throws Exception {
        return doSay(message);
    }

    private String doSay(String message) throws InterruptedException {
        int value = random.nextInt(200);
        System.out.println("say() costs " + value + "ms.");
        Thread.sleep(value);
        String returnValue = "Say："+message;
        System.out.println(returnValue);
        return returnValue;
    }

}
