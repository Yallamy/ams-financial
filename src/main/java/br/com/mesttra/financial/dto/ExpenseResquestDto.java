package br.com.mesttra.financial.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.mesttra.financial.util.Constantes;
import br.com.mesttra.financial.util.Message;
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
@ApiModel(description = Constantes.EXPENSE_REQUEST_DTO)
public class ExpenseResquestDto {

	@NotBlank(message = Message.FIELD_REQUIRED)
	@NotNull(message = Message.FIELD_REQUIRED)
	@ApiModelProperty(value = Constantes.REQUEST_EXPENSE_TYPE_DTO, position = 1)
    private String expenseType;
	
	@NotNull(message = Message.FIELD_REQUIRED)
	@ApiModelProperty(value = Constantes.REQUEST_AMOUNT_DTO, position = 2)
    private Double amount;

	@NotNull(message = Message.FIELD_REQUIRED + Message.DATE_FORMATTER)
	@ApiModelProperty(value = Constantes.REQUEST_DUE_DATE_DTO, position = 3)
    private LocalDate dueDate;

}
