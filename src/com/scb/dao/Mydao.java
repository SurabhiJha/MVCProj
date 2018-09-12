package com.scb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.scb.bean.Mybean1;


public class Mydao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int validate(Mybean1 mb)
	{
		Integer n = jdbcTemplate.queryForObject("select count(*) from customer where username='"+mb.getUser()+"' and password='"+mb.getPass()+"' ", Integer.class);
		if(n!=null)
			return n;
		return 0;
	}

	
	
	public List<Mybean1> select(Mybean1 m)
	{
		return jdbcTemplate.query("select * from customer where customerid='"+m.getUser()+"' ", new RowMapper<Mybean1>()
		{	public Mybean1 mapRow(ResultSet rs, int rownumber) throws SQLException
			{	Mybean1 mb = new Mybean1();
				
				mb.setUser(rs.getString(4));
				mb.setPass(rs.getString(5));
				return mb;
			}
		});
	}
	
	public List<Mybean1> showall(Mybean1 mb)
	{	return jdbcTemplate.query("select * from acc_details where username = ?", new Object[]{mb.getUser()}, new RowMapper<Mybean1>()
		{	public Mybean1 mapRow(ResultSet rs, int rownumber) throws SQLException
			{	Mybean1 mb = new Mybean1();
				mb.setAcnumber(rs.getInt(1));
				mb.setBalance(rs.getInt(2));
				
				return mb;
			}
		});
	}
	
	
	public int showdetails(Mybean1 mb)
	{
		return jdbcTemplate.update("");
	}



	public List<Mybean1> getNameFromDatabase(Mybean1 mb) {
		return jdbcTemplate.query("select cust_name from customer where cust_username=?", new Object[]{mb.getUser()},new RowMapper<Mybean1>()
		{	public Mybean1 mapRow(ResultSet rs, int rownumber) throws SQLException
		{	Mybean1 mb = new Mybean1();
			mb.setName(rs.getString(1));
			return mb;
		}
		});
	}



	public List<Mybean1> getLoanFromDatabase(Mybean1 mb) {
		return jdbcTemplate.query("select cust_name from customer where cust_username=?", new Object[]{mb.getUser()},new RowMapper<Mybean1>()
		{	public Mybean1 mapRow(ResultSet rs, int rownumber) throws SQLException
		{	Mybean1 mb = new Mybean1();
			mb.setName(rs.getString(1));
			return mb;
		}
		});
	}



	public List<Mybean1> getMiniStatFromDatabase(Mybean1 mb) {
		return jdbcTemplate.query("select cust_name from customer where cust_username=?", new Object[]{mb.getUser()},new RowMapper<Mybean1>()
		{	public Mybean1 mapRow(ResultSet rs, int rownumber) throws SQLException
		{	Mybean1 mb = new Mybean1();
			mb.setName(rs.getString(1));
			return mb;
		}
		});
	}



	public List<Mybean1> getMicroFromDatabase(Mybean1 mb) {
		return jdbcTemplate.query("select cust_name from customer where cust_username=?", new Object[]{mb.getUser()},new RowMapper<Mybean1>()
		{	public Mybean1 mapRow(ResultSet rs, int rownumber) throws SQLException
		{	Mybean1 mb = new Mybean1();
			mb.setName(rs.getString(1));
			return mb;
		}
		});
	}
}