package br.com.mesttra.financial.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mesttra.financial.entity.MonthlyExpense;

public interface MonthlyExpenseRepository extends JpaRepository<MonthlyExpense, Long>{

}
