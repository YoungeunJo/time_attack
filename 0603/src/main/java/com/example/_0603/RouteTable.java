package com.example._0603;

import java.util.List;

public class RouteTable {
    String ID;
    GateWay gateWay;
    List<Subnet> Subnet;

    public void addSubnet(Subnet subnet){
        Subnet.add(subnet);
    }
    public void setGateWay(GateWay gateWay){
        this.gateWay = gateWay;
    }

    public RouteTable(){}
}
