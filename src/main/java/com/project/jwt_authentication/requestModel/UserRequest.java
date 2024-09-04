package com.project.jwt_authentication.requestModel;

import lombok.Data;

@Data
public class UserRequest {

    String userName;
    String password;

}