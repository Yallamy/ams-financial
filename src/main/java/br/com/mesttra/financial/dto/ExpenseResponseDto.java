package br.com.mesttra.financial.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExpenseResponseDto {

	private Long id;
	
	private String expenseType;
	
    private Double amount;

    private LocalDate dueDate;
	
}
