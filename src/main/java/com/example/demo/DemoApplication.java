package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

@SpringBootApplication
@RestController
@RequestMapping("/demo")
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @GetMapping("/getTest")
    public String get(String str) {
        return new Result(str).toString();
    }

    @PostMapping("/postTest")
    public String post(@RequestParam("str") String str, @RequestBody Object o) {
        return new Result("post success str = " + str, o).toString();
    }

    @PutMapping("/putTest")
    public String put(@RequestParam("str") String str, @RequestBody Object o) {
        return new Result("put success str = " + str, o).toString();
    }

    @DeleteMapping("/deleteTest")
    public String delete(@RequestParam("str") String str, @RequestBody Object o) {
        return new Result("delete success str = " + str, o).toString();
    }

    @PatchMapping("/patchTest")
    public String patch(@RequestParam("str") String str, @RequestBody Object o) {
        return new Result("patch success str = " + str, o).toString();
    }

    @RequestMapping(value = "/headTest", method = RequestMethod.HEAD)
    public String head(@RequestParam("str") String str, @RequestBody Object o) {
        return new Result("head success str = " + str, o).toString();
    }

    @RequestMapping(value = "/optionsTest", method = RequestMethod.OPTIONS)
    public String options(@RequestParam("str") String str, @RequestBody Object o) {
        return new Result("options success str = " + str, o).toString();
    }

    class Result implements Serializable {

        private String message;

        private Object o;

        public Result(String message) {
            this.message = message;
        }

        public Result(String message, Object o) {
            this.message = message;
            this.o = o;
        }

        @Override
        public String toString() {
            return message + " ****  o: " + o;
        }
    }

}
