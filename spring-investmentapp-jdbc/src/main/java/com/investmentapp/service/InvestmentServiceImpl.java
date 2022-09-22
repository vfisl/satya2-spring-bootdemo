package com.investmentapp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.investmentapp.model.Investment;
import com.investmentapp.repository.IInvestmentRepository;

@Service
public class InvestmentServiceImpl implements IInvestmentService {

	
	IInvestmentRepository investmentRepository;
	@Autowired
	public void setInvestmentRepository(IInvestmentRepository investmentRepository) {
		this.investmentRepository = investmentRepository;
	}

	@Override
	public void addInvestment(Investment investment) {
		investmentRepository.addInvestment(investment);
		
	}

	@Override
	public void updateInvestment(int planID, double amount) {
		investmentRepository.updateInvestment(planID, amount);
		
	}

	@Override
	public void deleteInvestment(int planID) {
		investmentRepository.deleteInvestment(planID);
		
	}

	@Override
	public List<Investment> getByType(String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Investment> getByPurpose(String purpose) {
		
		return investmentRepository.findByPurpose(purpose);
	}

	@Override
	public List<Investment> getAll() {
		return investmentRepository.findAll().stream()
				.sorted((i1,i2)->i1.getPlanName()
						.compareTo(i2.getPlanName())).collect(Collectors.toList());
	}

	@Override
	public List<Investment> getByRiskAndTerm(String risk, int term) {
		// TODO Auto-generated method stub
		return investmentRepository.findByRiskAndTerm(risk, term);
	}

	@Override
	public double calculateMaturity(Investment investment) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Investment getByID(int planId) {
		// TODO Auto-generated method stub
		return investmentRepository.findByID(planId);
	}

}
