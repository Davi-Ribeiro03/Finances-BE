package com.davi.finances.controllers;

import com.davi.finances.configs.ApiResponse;
import com.davi.finances.dtos.transaction.TransactionDto;
import com.davi.finances.dtos.transaction.TransactionsWithStatistics;
import com.davi.finances.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService tService;

    @GetMapping()
    public ResponseEntity<ApiResponse<TransactionsWithStatistics>> GetAll(@RequestParam LocalDate monthReference){
        TransactionsWithStatistics transactions = tService.GetAll(monthReference);

        ApiResponse<TransactionsWithStatistics> response = ApiResponse.success("Transaction list", transactions);

        return ResponseEntity.ok(response);
    }


    @PostMapping()
    public ResponseEntity<ApiResponse<TransactionDto>> AddTransaction(@RequestBody TransactionDto transaction){
        tService.Add(transaction);
        ApiResponse<TransactionDto> response = ApiResponse.success(transaction.type() + " successfully registered",transaction);

        return ResponseEntity.ok().body(response);

    }

    @PutMapping()
    public ResponseEntity EditTransaction(@RequestBody TransactionDto transaction){
        tService.Edit(transaction);

        ApiResponse<TransactionDto> response = ApiResponse.success("Transaction edited successfully",transaction );

        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity DeleteTransaction(@PathVariable Long id){
        tService.Delete(id);

        ApiResponse<Object> response = ApiResponse.success("Transaction successfully deleted",null);

        return ResponseEntity.ok().body(response);
    }
}
