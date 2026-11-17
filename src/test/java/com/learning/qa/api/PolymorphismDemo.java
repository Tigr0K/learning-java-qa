package com.learning.qa.api;

import java.util.ArrayList;
import java.util.List;

public class PolymorphismDemo {
    static void main(String[] args) {
        List<ApiRequest> listOfReq = new ArrayList<>();
        listOfReq.add(new GetUserRequest("2","/users/"));
        listOfReq.add(new CreateUserRequest("/dows"));
        listOfReq.add(new CreateUserRequest("/cow"));

        listOfReq.forEach(req-> System.out.println(req.describe()));

        if(listOfReq.get(0) instanceof GetUserRequest cur){
          System.out.println(cur.getUserId());
        }

    }
}
