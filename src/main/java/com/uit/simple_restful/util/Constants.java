package com.uit.simple_restful.util;

public class Constants {

    public static final String Tasks="/tasks";
    public static final String Tasks_ID="/tasks/{id}";
    public static final String Demo="/demo";
    public static final String Title_Description_Require="Title and description are required";
    public static final String ID_Not_Exist="ID not existed";
    public static final String Login="/login";
    public static final String Get="/get";
    public static final String Base_Url="/api/v1";
    public static final String User_Endpoint="/user";

    public static final String Task_Delete_Success="Task deleted successfully";
    public static final String Task_Not_Existed="Task is not existed";
    public static final Long jwtExpiration = 10800000000000L;
    public static final String authHeader = "Authorization";
    public static final String tokenPrefix = "Bearer ";
    public static final String jwtSecret="tanvuu998";
}
