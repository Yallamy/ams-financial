package br.com.mesttra.financial.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mesttra.financial.entity.MonthlyExpense;
import br.com.mesttra.financial.exception.ValidationException;
import br.com.mesttra.financial.repository.MonthlyExpenseRepository;

@Service
public class MonthlyExpenseService {
	
	@Autowired
	private MonthlyExpenseRepository repository;
	
	public MonthlyExpense addExpense(MonthlyExpense expense) throws ValidationException {
		
		if(Objects.isNull(expense)) {
			throw new ValidationException();
		}
		
		return repository.save(expense);
	}

}
