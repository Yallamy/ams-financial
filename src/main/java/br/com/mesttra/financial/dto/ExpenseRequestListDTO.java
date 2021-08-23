package br.com.mesttra.financial.dto;

import java.time.LocalDate;

import br.com.mesttra.financial.util.Constantes;
import io.swagger.annotations.ApiModelProperty;

public class ExpenseRequestListDTO {

	@ApiModelProperty(value = Constantes.REQUEST_EXPENSE_LIST_ID_DTO, position = 1)
	private Long id;
	
	@ApiModelProperty(value = Constantes.REQUEST_EXPENSE_TYPE_LIST_DTO, position = 2)
	private String expenseType;
	
	@ApiModelProperty(value = Constantes.REQUEST_AMOUNT_LIST_DTO, position = 3)
    private Double amount;

	@ApiModelProperty(value = Constantes.REQUEST_DUE_DATE_LIST_DTO, position = 4)
    private LocalDate dueDate;
}
