package com.gupao.jdbc;

import com.gupao.jdbc.dao.MemberDao;

import java.util.List;

public class test {

    public static void main(String [] args){

        MemberDao  memberDao = new MemberDao(null);

        List<?> result = memberDao.selectAll();

        System.out.println(result);
    }
}
