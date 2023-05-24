package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MathController {
    @RequestMapping(path = "/add/{number1}/and/{number2}", method= RequestMethod.GET)
    @ResponseBody
    public int add(@PathVariable int number1, @PathVariable int number2){

      return number1 + number2;
    }
    @RequestMapping(path = "/subtract/{number1}/from/{number2}", method= RequestMethod.GET)
    @ResponseBody
    public int subtract(@PathVariable int number1, @PathVariable int number2) {

        return number1 - number2;
    }

    @RequestMapping(path = "/multiply/{number1}/and/{number2}", method= RequestMethod.GET)
    @ResponseBody
    public int multiply(@PathVariable int number1, @PathVariable int number2) {

        return number1 * number2;
    }

    @RequestMapping(path = "/divide/{number1}/from/{number2}", method= RequestMethod.GET)
    @ResponseBody
    public int divide(@PathVariable int number1, @PathVariable int number2) {

        return number1 /number2;
    }

}
