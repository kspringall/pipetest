package com.pipelinetest.pipetest.controller;

import com.pipelinetest.pipetest.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MainController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class.getName());

    @RequestMapping("/")
    public Response greeting()
    {
        LOGGER.info("The / endpoint was called");
        return new Response(counter.incrementAndGet(), String.format(template, "Hello World"));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/g")
    public Response greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        LOGGER.info("The /g endpoint was called");
        LOGGER.info("The parameter used: " + name);
        return new Response(counter.incrementAndGet(), String.format(template, name));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/tester")
    public Response greetingTest()
    {
        LOGGER.info("The /tester endpoint was called");
        return new Response(counter.incrementAndGet(), String.format(template, "Hello Tester!"));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/n")
    public Response greetingName(@RequestParam(value = "name", defaultValue = "World") String name) {
        LOGGER.info("The /n endpoint was called");
        LOGGER.info("The parameter used: " + name);
        return new Response(counter.incrementAndGet(), String.format(template, name));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/greeting/{personName}")
    public Response greetingPost(@PathVariable("personName") String personName) {
        Response response = new Response(counter.incrementAndGet(), String.format(template, personName));
        LOGGER.info("The /personName endpoint was called");
        LOGGER.info("The path variable received was: " + personName);
        LOGGER.info("The response given to the caller: " + response.toString());
        return response; 
    }

}
