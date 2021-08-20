package br.com.mesttra.financial.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.mesttra.financial.dto.ExpenseResponseDto;
import br.com.mesttra.financial.dto.ExpenseResquestDto;
import br.com.mesttra.financial.entity.MonthlyExpense;
import br.com.mesttra.financial.exception.ValidationException;
import br.com.mesttra.financial.service.MonthlyExpenseService;
import br.com.mesttra.financial.util.Constantes;
import br.com.mesttra.financial.util.Util;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value=Constantes.PATH_FINANCIAL, produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = Constantes.PATH_FINANCIAL, produces = MediaType.APPLICATION_JSON_VALUE, tags = { Constantes.TAG_FINANCIAL })
public class MonthlyExpenseResource {
	
	@Autowired
	private MonthlyExpenseService service;
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ApiOperation(value = Constantes.ADD_EXPENSE, 
	notes = Constantes.ADD_EXPENSE_NOTES, response = ExpenseResponseDto.class)
	public @ResponseBody ResponseEntity<?> addExpense(@Valid @RequestBody ExpenseResquestDto request) 
			throws ValidationException {
		
		MonthlyExpense expense = Util.convertModelMapper(request, MonthlyExpense.class);
		
		expense = service.addExpense(expense);

		ExpenseResponseDto response = Util.convertModelMapper(expense, ExpenseResponseDto.class);

		return new ResponseEntity<ExpenseResponseDto>(response, HttpStatus.OK);
	}

}
