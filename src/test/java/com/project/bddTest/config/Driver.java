package com.project.bddTest.config;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PreDestroy;

@Service
@Slf4j
public class Driver {

    @Autowired
    private WebDriver driver;

    @PreDestroy
    public void destroy() {
        if (driver != null) {
            log.info("DESTROY: driver quit success");
            driver.quit();
        }
    }
}
