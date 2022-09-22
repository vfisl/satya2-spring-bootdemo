package com.investmentapp.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.investmentapp.model.Investment;

public class InvestmentRowMapper implements RowMapper<Investment>{

	@Override
	public Investment mapRow(ResultSet rs, int rowNum) throws SQLException {
		Investment investment=new Investment();
		investment.setAmount(rs.getDouble("amount"));
		investment.setEntryAge(rs.getInt("entry_age"));
		investment.setNominee(rs.getString("nominee"));
		investment.setPlanId(rs.getInt("plan_id"));
		investment.setPlanName(rs.getString("plan_name"));
		investment.setPurpose(rs.getString("purpose"));
		investment.setRisk(rs.getString("risk"));
		investment.setTerm(rs.getInt("term"));
		investment.setType(rs.getString("type"));
		return investment;
	}
	

}
