package com.pluralsight;

import com.pluralsight.aspect.TracingAspect;
import com.pluralsight.config.SimpleAspectConfiguration;
import com.pluralsight.service.SimpleService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SimpleAspectConfiguration.class)
public class SimpleAspectConfigurationTest {

    @Autowired
    TracingAspect tracingAspect;

    @Autowired
    SimpleService simpleService;

    @Test
    public void aspectCalled() {
        assertFalse(tracingAspect.isEnteringCalled());
        simpleService.doSomething(42);
        assertTrue(tracingAspect.isEnteringCalled());
    }

}
