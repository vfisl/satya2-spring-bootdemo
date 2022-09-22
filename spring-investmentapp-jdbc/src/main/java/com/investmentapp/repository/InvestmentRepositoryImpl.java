package com.investmentapp.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.investmentapp.model.Investment;
import com.investmentapp.util.DBQueries;
@Repository
public class InvestmentRepositoryImpl implements IInvestmentRepository {

	private JdbcTemplate jdbcTemplate;
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void addInvestment(Investment investment) {
		String sql=DBQueries.insertQUERY;
		Object[] invArray= {investment.getPlanName(),investment.getEntryAge(),investment.getType(),investment.getAmount(),
				            investment.getPurpose(),investment.getRisk(),investment.getNominee(),investment.getTerm()};
		jdbcTemplate.update(DBQueries.insertQUERY,invArray);
	}

	@Override
	public void updateInvestment(int planID, double amount) {
		String sql=DBQueries.updateQUERY;
	     jdbcTemplate.update(sql, amount,planID);
		
	}

	@Override
	public void deleteInvestment(int planID) {
		jdbcTemplate.update(DBQueries.deleteQuery, planID);
	}

	@Override
	public List<Investment> findByType(String type) {
	     return jdbcTemplate.query(DBQueries.SELECTBYTYPE,(rs,rowNum)->{
	    	 
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
	     }, type);
	}

	@Override
	public List<Investment> findByPurpose(String purpose) {
		List<Investment>investments=jdbcTemplate.query(DBQueries.SELECTBYPURPOSE,new RowMapper<Investment>() {
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
			return investment;}
		}, purpose);
		return investments;
	}

	@Override
	public List<Investment> findAll() {
	  return	jdbcTemplate.query(DBQueries.SELECTQUERY, new InvestmentRowMapper());
	}

	@Override
	public List<Investment> findByRiskAndTerm(String risk, int term) {
		
		return jdbcTemplate.query(DBQueries.SELECTBYRISKANDTERM, new InvestmentRowMapper(),risk,term);
	}

	@Override
	public double calculateMaturity(Investment investment) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Investment findByID(int planId) {
		return jdbcTemplate.queryForObject(DBQueries.SELECTBYID,new InvestmentRowMapper(),planId);
	
	}

}
