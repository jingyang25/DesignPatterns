package com.gupao.simple;

import java.util.HashMap;
import java.util.Map;

public class Leader implements IEmployee {

    private Map<String,IEmployee> target = new HashMap<>();

    public Leader(){
        target.put("加密",new EmployeeA());
        target.put("登录",new EmployeeB());
    }
    @Override
    public void doing(String command) {

        target.get(command).doing(command);
    }
}
