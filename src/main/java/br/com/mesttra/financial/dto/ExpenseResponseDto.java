package br.com.mesttra.financial.dto;

import java.time.LocalDate;

import br.com.mesttra.financial.util.Constantes;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(description = Constantes.EXPENSE_RESPONSE_DTO)
public class ExpenseResponseDto {

	@ApiModelProperty(value = Constantes.RESPONSE_EXPENSE_ID_DTO, position = 1)
	private Long id;
	
	@ApiModelProperty(value = Constantes.RESPONSE_EXPENSE_TYPE_DTO, position = 2)
	private String expenseType;
	
	@ApiModelProperty(value = Constantes.RESPONSE_AMOUNT_DTO, position = 3)
    private Double amount;

	@ApiModelProperty(value = Constantes.RESPONSE_DUE_DATE_DTO, position = 4)
    private LocalDate dueDate;
	
}
