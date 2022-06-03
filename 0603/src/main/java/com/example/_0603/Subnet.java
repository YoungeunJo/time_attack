package com.example._0603;

public class Subnet {
    int id;
    String region;
    String ip;
    RouteTable routeTable;

    public void transfer(String msg){
        System.out.println(msg);
    }

    public Subnet(){}
    public Subnet(int id, String ip, String region){}
}
