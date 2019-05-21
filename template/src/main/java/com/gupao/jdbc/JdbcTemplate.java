package com.gupao.jdbc;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract  class JdbcTemplate {
    
    private DataSource dataSource;

    public JdbcTemplate(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    public List<?> executeQuery(String sql, RowMapper<?> rowMapper, Object[] values){

        List<?> result = null;
        try {
            Connection connection = this.getConnection();

            PreparedStatement preparedStatement = this.createPrepareStatement(connection,sql);

            ResultSet rs = (ResultSet) this.executeQuery(preparedStatement,values);

            result = this.paresResultSet(rs,rowMapper);

            this.closeResultSet(rs);

            this.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
        
    }

    protected  Object executeQuery(PreparedStatement preparedStatement, Object[] values) throws Exception {
        for (int i=0;i<values.length;i++){
            preparedStatement.setObject(i,values);
        }
        return preparedStatement.executeQuery();
    }

    protected  void closeConnection(Connection connection) throws Exception {
        connection.close();
    }

    protected  void closeResultSet(ResultSet rs) throws Exception {

        rs.close();

    }

    protected  List<?> paresResultSet(ResultSet rs, RowMapper<?> rowMapper) throws Exception {

        List<Object> result = new ArrayList<>();

        int rowNum = 1;

        while(rs.next()){

            result.add(rowMapper.mapRow(rs,rowNum++));


        }

        return result;
    }

    protected  PreparedStatement createPrepareStatement(Connection connection, String sql) throws SQLException {

        return connection.prepareStatement(sql);
    }

    protected  Connection getConnection() throws Exception {

        return this.dataSource.getConnection();
    }
}
