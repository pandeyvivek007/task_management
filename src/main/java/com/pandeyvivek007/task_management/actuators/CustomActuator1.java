package com.pandeyvivek007.task_management.actuators;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "custom")
public class CustomActuator1 {

    @ReadOperation
    public String customActuator(){
        return "This is my custom actuator";
    }
}
