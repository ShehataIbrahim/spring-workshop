package com.ih.spring.components.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
@Service
public class UserService implements UserDao,RowMapper<User> {

	JdbcTemplate jdbcTemplate;
	@Autowired 
	public UserService(DataSource datasource) {
		jdbcTemplate=new JdbcTemplate(datasource);
	}
	
	@Override
	public User findUser(String name) {
		String sql="select name, password, enabled from security_user where name=?";
		User user = jdbcTemplate.queryForObject(sql, 
                new Object[]{name}, this);
		return user;
	}

	@Override
	public Collection<User> findUsers() {
		 String sql = "select name, password, enabled from security_user";
	      List<User> users = jdbcTemplate.query(sql, this);
		return users;
	}

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user=new User();
		user.setName(rs.getString("name"));
		user.setPassword(rs.getString("password"));
		user.setEnabled(rs.getBoolean("enabled"));
		return user;
	}
}
