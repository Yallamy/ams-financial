package br.com.mesttra.financial.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExpenseResquestDto {

	@NotBlank(message = "Campo não pode ser vazio ou null")
	@NotNull(message = "Campo não pode ser vazio ou null")
    private String expenseType;
	
	@NotNull(message = "Campo não pode ser vazio ou null")
    private Double amount;

	@NotNull(message = "Campo não pode ser vazio ou null. Formato: YYYY-MM-DD")
    private LocalDate dueDate;

}
