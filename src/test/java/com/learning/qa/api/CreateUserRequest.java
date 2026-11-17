package com.learning.qa.api;

public class CreateUserRequest extends ApiRequest {

    public CreateUserRequest(String path){
        super(path);
    }

    @Override
    public String getMethod() {
        return "POST";
    }
}
