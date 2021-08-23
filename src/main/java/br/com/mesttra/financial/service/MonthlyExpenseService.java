package br.com.mesttra.financial.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.mesttra.financial.entity.MonthlyExpense;
import br.com.mesttra.financial.exception.ValidationEnumMessage;
import br.com.mesttra.financial.exception.ValidationException;
import br.com.mesttra.financial.repository.MonthlyExpenseRepository;

/**
 * 
 * @author Yallamy Nascimento
 */
@Service
public class MonthlyExpenseService {
	
	@Autowired
	private MonthlyExpenseRepository repository;
	
	/**
	 * 
	 * @param expense
	 * @return
	 * @throws ValidationException
	 * @author Yallamy Nascimento
	 * 20 de ago de 2021
	 */
	public MonthlyExpense addExpense(MonthlyExpense expense) throws ValidationException {
		
		if(Objects.isNull(expense)) {
			throw new ValidationException(ValidationEnumMessage.ERRO_CONSISTENCIA);
		}
		
		return repository.save(expense);
	}
	
	/**
	 * 
	 * @param monthlyExpense
	 * @param pageable
	 * @return
	 * @throws ValidationException
	 * @author Yallamy Nascimento
	 * 20 de ago de 2021
	 */
	public Page<MonthlyExpense> list(MonthlyExpense monthlyExpense, Pageable pageable) throws ValidationException {
		
		if(Objects.isNull(pageable)) {
			throw new ValidationException(ValidationEnumMessage.ERRO_CONSISTENCIA);
		}
		
		if(Objects.isNull(monthlyExpense)) {
			monthlyExpense = MonthlyExpense.builder().build();
		}
		
		ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreNullValues();
		Example<MonthlyExpense> example = Example.of(monthlyExpense, matcher);
		
		return repository.findAll(example, pageable); 
	}

}
