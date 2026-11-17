package com.learning.qa.api;

public class GetUserRequest extends ApiRequest{
    private String userId;
    public GetUserRequest(String userId, String path){
        super(path + userId);
        this.userId = userId;
    }
    public String getUserId(){
        return userId;
    }

    @Override
    public String getMethod() {
        return "GET";
    }
}
