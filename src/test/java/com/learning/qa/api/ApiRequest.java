package com.learning.qa.api;

public abstract class ApiRequest {
    private String endpoint;
    public ApiRequest(String endpoint){
        this.endpoint = endpoint;
    }
    public abstract String getMethod();
    public String describe(){
        return getMethod() + endpoint;
    }
}
