package com.gupao.jdbc;

import java.sql.ResultSet;

// ORM 映射定制化接口
public interface RowMapper<T> {


    T mapRow(ResultSet rs,int rowNum) throws Exception;


}
