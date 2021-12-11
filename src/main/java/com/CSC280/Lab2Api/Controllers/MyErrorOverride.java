package com.CSC280.Lab2Api.Controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class MyErrorOverride implements ErrorController {

    @RequestMapping(path="/error", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String handleError(HttpServletRequest req, HttpServletResponse res){
        Integer statusCode = (Integer) req.getAttribute("javax.servlet.error.status_code");
        Exception exception = (Exception) req.getAttribute("javax.servlet.error.exception");
        //not used yet
        MyExceptionMessage message = new MyExceptionMessage("Blah blah blah: " /*+ exception.getMessage()*/, statusCode, exception);
        //----------------
        System.out.println("MyErrorOverride::handleError()");
        res.setStatus(statusCode);

        if (statusCode == 401){//if the user is not authenticated hit this
            return "401, You are not authenticated!";
        }else if(statusCode == 403){//if the user does not have the access level needed, hit this
            return "403, you do not have access to that!";
        }
        return statusCode.toString();//anything else
        //return new MyExceptionMessage("oof", 69);
    }

    public String getErrorPath(){
        return "/error";
    }

}
