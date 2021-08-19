package br.com.mesttra.financial.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.mesttra.financial.util.Message;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExpenseResquestDto {

	@NotBlank(message = Message.FIELD_REQUIRED)
	@NotNull(message = Message.FIELD_REQUIRED)
    private String expenseType;
	
	@NotNull(message = Message.FIELD_REQUIRED)
    private Double amount;

	@NotNull(message = Message.FIELD_REQUIRED + Message.DATE_FORMATTER)
    private LocalDate dueDate;

}
