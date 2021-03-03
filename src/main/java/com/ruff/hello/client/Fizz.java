package com.ruff.hello.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.TimeUnit;


public class Fizz {
    static Logger logger = LoggerFactory.getLogger(Fizz.class);
    static String privateKey = "7a90e31dcd8e7b60dd89c9824cc96064c5e1538f94b7d7c1b3e5bf6a7a935cb8";

    public static void main(String[] args) {
        logger.debug("Asset-app Contract");
        logger.debug("-----------------------------------------" );

        AssetClient assetClient = new AssetClient(1,privateKey);
        assetClient.sayHello();
        assetClient.stop();
    }

    public static String convert(int fizzBuzz) {
        if (fizzBuzz % 15 == 0) {
            return "FizzBuzz";
        }
        if (fizzBuzz % 3 == 0) {
            return "Fizz";
        }
        if (fizzBuzz % 5 == 0) {
            return "Buzz";
        }
        return String.valueOf(fizzBuzz);
    }
}
