package com.pluralsight;

import com.pluralsight.aspect.TracingAspect;
import com.pluralsight.config.SimpleAspectConfiguration;
import com.pluralsight.service.SimpleService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AspectApplication {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(SimpleAspectConfiguration.class);

        TracingAspect tracingAspect = context.getBean(TracingAspect.class);

        SimpleService simpleService = context.getBean(SimpleService.class);
        simpleService.greet();

//        System.out.println(tracingAspect.isEnteringCalled());
//        simpleService.doSomething();
//        System.out.println(tracingAspect.isEnteringCalled());

    }

}
