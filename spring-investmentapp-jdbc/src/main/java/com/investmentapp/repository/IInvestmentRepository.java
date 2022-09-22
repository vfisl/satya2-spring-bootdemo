package com.investmentapp.repository;

import java.util.List;

import com.investmentapp.model.Investment;

public interface IInvestmentRepository {


	void addInvestment(Investment investment);
	void updateInvestment(int planID, double amount);
	void deleteInvestment(int planID);
	List<Investment> findByType(String type);
	List<Investment> findByPurpose(String purpose);
	List<Investment> findAll();
	List<Investment> findByRiskAndTerm(String risk,int term);
	double calculateMaturity(Investment investment);
	Investment findByID(int planId);
}
