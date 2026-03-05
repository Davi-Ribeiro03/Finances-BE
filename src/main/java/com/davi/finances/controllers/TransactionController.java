package com.davi.finances.controllers;

import com.davi.finances.dtos.transaction.TransactionDto;
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
    public ResponseEntity GetAll(@RequestParam LocalDate monthReference){
        return tService.GetAll(monthReference);
    }


    @PostMapping()
    public ResponseEntity AddTransaction(@RequestBody TransactionDto transaction){

        return tService.Add(transaction);
    }

    @PutMapping()
    public ResponseEntity EditTransaction(@RequestBody TransactionDto transaction){
        return tService.Edit(transaction);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity DeleteTransaction(@PathVariable Long id){
        return tService.Delete(id);
    }
}
