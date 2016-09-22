package com.racing.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by maomao on 16/9/22.
 */
@RestController
@RequestMapping(value = "/test")
public class TestController {

    @RequestMapping(method = RequestMethod.GET)
    public TestDTO test() {
        TestDTO testDTO=new TestDTO();
        testDTO.setId(1l);
        testDTO.setName("success");
        return testDTO;
    }

    public class TestDTO{
        private Long id;
        private String name;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
