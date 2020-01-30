package org.example.model;

import org.example.model.ConnectionDetail;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionMapper implements RowMapper<ConnectionDetail> {

    public ConnectionDetail mapRow(ResultSet resultSet, int i) throws SQLException {

        ConnectionDetail connectionDetail = new ConnectionDetail();
        connectionDetail.setSourceID(resultSet.getString("SourceId"));
        connectionDetail.setTargetID(resultSet.getString("TargetId"));
        System.out.println(connectionDetail.toString());
        return connectionDetail;
    }

}