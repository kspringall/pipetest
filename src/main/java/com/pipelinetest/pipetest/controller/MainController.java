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
    public String greeting() {
        return "Hello World";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/g")
    public Response greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Response(counter.incrementAndGet(), String.format(template, name));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/tester")
    public String greetingTest() {
        return "Hello Tester!";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/kimball")
    public String greetingKimball() {
        return "Hello Kimball!";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/n")
    public Response greetingName(@RequestParam(value = "name", defaultValue = "World") String name) {
        LOGGER.info("The /n endpoint was called");
        return new Response(counter.incrementAndGet(), String.format(template, name));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/greeting/{personName}")
    public Response greetingPost(@PathVariable("personName") String personName) {
        return new Response(counter.incrementAndGet(), String.format(template, personName));
    }

}
