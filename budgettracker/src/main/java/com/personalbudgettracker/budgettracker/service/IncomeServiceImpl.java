package com.personalbudgettracker.budgettracker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personalbudgettracker.budgettracker.exceptions.IncomeNotFoundException;
import com.personalbudgettracker.budgettracker.exceptions.NoIncomesFoundException;
import com.personalbudgettracker.budgettracker.model.Income;
import com.personalbudgettracker.budgettracker.repository.IncomeRepo;

@Service
public class IncomeServiceImpl implements IncomeService{
    @Autowired 
    private IncomeRepo incomeRepo;


    @Override
    public Income addIncome(Income income) {
       
        return incomeRepo.save(income);

    }

  @Override
public List<Income> getAllIncomes() throws NoIncomesFoundException {
    List<Income> incomes = incomeRepo.findAll();
    if (incomes.isEmpty()) {
        throw new NoIncomesFoundException("No incomes found");
    }
    return incomes;
}


    public Income getIncomeById(Long incomeId) throws IncomeNotFoundException {
        Optional<Income> incomeOpt = incomeRepo.findById(incomeId);
        if (incomeOpt.isPresent()) {
            return incomeOpt.get();
        } else {
            throw new IncomeNotFoundException("Income with ID " + incomeId + " not found");
        }
    }
    
    

    @Override
    public Income updateIncome(Long incomeId, Income updatedIncome) throws IncomeNotFoundException {
        Optional<Income> incomeOpt = incomeRepo.findById(incomeId);
        if (incomeOpt.isPresent()) {
            Income newIncome = incomeOpt.get();
            newIncome.setAmount(updatedIncome.getAmount());
            newIncome.setDescription(updatedIncome.getDescription());
            newIncome.setDate(updatedIncome.getDate());
            newIncome.setUser(updatedIncome.getUser());
            newIncome.setBudget(updatedIncome.getBudget());

            return incomeRepo.save(newIncome);
        } else {
            throw new IncomeNotFoundException("Income with ID " + incomeId + " not found");
        }
    }
    

    @Override
    public void deleteIncome(Long incomeId) throws IncomeNotFoundException {
        if (incomeRepo.existsById(incomeId)) {
            incomeRepo.deleteById(incomeId);
        } else {
            throw new IncomeNotFoundException("Income with ID " + incomeId + " not found");
        }
    }
    
    
}
