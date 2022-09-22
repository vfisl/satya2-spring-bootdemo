package com.investmentapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.investmentapp.model.Investment;
import com.investmentapp.model.Nominee;
import com.investmentapp.model.PlanType;
import com.investmentapp.model.Purpose;
import com.investmentapp.model.Risk;
import com.investmentapp.service.IInvestmentService;

@SpringBootApplication
public class SpringInvestmentappJdbcApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringInvestmentappJdbcApplication.class, args);
	}
	@Autowired
  IInvestmentService investmentService;
	
	@Override
	public void run(String... args) throws Exception {
		//investmentService.addInvestment(new Investment("Ranjhana",18,PlanType.ulip.type ,15000,Purpose.EDUCATION.toString(),Risk.LOW.toString(),Nominee.WIFE.toString(),20));
		investmentService.getAll().forEach(System.out::println);
		System.out.println("by purpose");
		investmentService.getByPurpose("marriage").forEach(System.out::println);
		System.out.println("by id");
		System.out.println(investmentService.getByID(2));
		System.out.println("by type");
		investmentService.getByPurpose(PlanType.ulip.name()).forEach(System.out::println);
		System.out.println("by risk and term<");
		investmentService.getByRiskAndTerm(Risk.HIGH.toString(),20).forEach(System.out::println);
	}

}
