package com.qiuqian.domain;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
@MappedJdbcTypes(JdbcType.VARCHAR)
@MappedTypes(Name.class)
public class NameTypeHandler extends BaseTypeHandler<Name> {
    //将java对象转换成为数据库所需要的对象
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Name name, JdbcType jdbcType) throws SQLException {
        preparedStatement.setString(i,name.getFirst()+"-"+name.getLast());
        
    }

    @Override
    public Name getNullableResult(ResultSet resultSet, String columnName) throws SQLException {
        //取出的实际值
        String val = resultSet.getString(columnName);
        String[] tokens=val.split("-");
        Name name=new Name(tokens[0],tokens[1]);
        return name;
    }

    @Override
    public Name getNullableResult(ResultSet resultSet, int columnIndex) throws SQLException {
        //取出的实际值
        String val = resultSet.getString(columnIndex);
        String[] tokens=val.split("-");
        Name name=new Name(tokens[0],tokens[1]);
        return name;
    }
    //将数据库的取出数据转换成为Java类型
    @Override
    public Name getNullableResult(CallableStatement callableStatement, int columnIndex) throws SQLException {
        //取出实际的值
        String val =callableStatement.getString(columnIndex);
        String[] tokens=val.split("-");
        Name name=new Name(tokens[0],tokens[1]);
        return name;
    }
}
