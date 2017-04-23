package com.manivchuk.db;

import com.manivchuk.beans.LineConfig;
import com.manivchuk.dao.DaoMCastLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 27.03.2017.
 */
@Component("mySqlDAO")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE)
public class MySqlDAO implements DaoMCastLine {

    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource){
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public void createLineConfig(LineConfig line) {
        // String query = "INSERT INTO mcastline.mcast_line(hostname, ipsocket, portSocket, ipmcast, portmcast) values('" + line.getHostname() + "', '" + line.getIpSocket() + "', '" + line.getPortSocket() + "', '" + line.getIpMcast() + "', '" + line.getPortMcast() + "');";
        String sql = "INSERT INTO mcastline.mcast_line(hostname, ipsocket, portSocket, ipmcast, portmcast) values (:hostname, :ipsocket, :portSocket, :ipmcast, :portmcast)";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("hostname", line.getHostname());
        params.addValue("ipsocket", line.getIpSocket());
        params.addValue("portSocket", line.getPortSocket());
        params.addValue("ipmcast", line.getIpMcast());
        params.addValue("portmcast", line.getPortMcast());

        jdbcTemplate.update(sql,params,keyHolder);
    }

    @Override
    public List<LineConfig> getAllLineConfig() {
        String sql = "select * from mcast_line";

        return jdbcTemplate.query(sql, new ResultSetExtractor<List<LineConfig>>() {
            @Override
            public List<LineConfig> extractData(ResultSet rs) throws SQLException, DataAccessException {
                List<LineConfig> lineConfigsList = new ArrayList<>();
                while(rs.next()){
                    LineConfig line = new LineConfig();
                    line.setHostname(rs.getString("hostname"));
                    line.setIpSocket(rs.getString("ipsocket"));
                    line.setPortSocket(rs.getInt("portSocket"));
                    line.setIpMcast(rs.getString("ipmcast"));
                    line.setPortMcast(rs.getInt("portmcast"));
                    lineConfigsList.add(line);
                }
                return lineConfigsList;
            }
        });
    }

    @Override
    public LineConfig getLineConfigByHostname(String hostname) {
        String sql = "select hostname,ipsocket,portSocket,ipmcast,portmcast from mcast_line where hostname=:hostname";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("hostname", hostname);

        return jdbcTemplate.queryForObject(sql, params, new LineRowMapper());
    }

    @Override
    public boolean updateLineConfig(LineConfig line) {
        return false;
    }

    @Override
    public boolean deleteLineConfig(LineConfig line) {
        return false;
    }

    private static class LineRowMapper implements RowMapper<LineConfig> {
        @Override
        public LineConfig mapRow(ResultSet rs, int rowNum) throws SQLException {
            LineConfig line = new LineConfig();
            line.setHostname(rs.getString("hostname"));
            line.setIpSocket(rs.getString("ipsocket"));
            line.setPortSocket(rs.getInt("portSocket"));
            line.setIpMcast(rs.getString("ipmcast"));
            line.setPortMcast(rs.getInt("portmcast"));
            return line;
        }
    }
}
