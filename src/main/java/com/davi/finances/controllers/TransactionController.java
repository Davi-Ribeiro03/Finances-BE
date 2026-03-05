package com.davi.finances.controllers;

import com.davi.finances.dtos.transaction.TransactionDto;
import com.davi.finances.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService tService;

    @GetMapping()
    public ResponseEntity GetAll(@RequestParam LocalDate monthReference){
        return tService.GetAll(monthReference);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<TransactionDto> GetAll(@PathVariable Long id){
//        return transactions
//                .stream()
//                .filter(t -> t.id().equals(id))
//                .findFirst()
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }
//
//    @PostMapping()
//    public ResponseEntity<List<TransactionDto>> AddTransaction(@RequestBody TransactionDto transaction){
//        transactions.add(transaction);
//
//        return ResponseEntity.ok(transactions);
//    }
//
//    @PutMapping()
//    public ResponseEntity<TransactionDto> EditTransaction(@RequestBody TransactionDto transaction){
//        transactions.remove(transaction.id().intValue()-1);
//        transactions.add( transaction);
//
//        return transactions
//                .stream()
//                .filter(t -> t.id().equals(transaction.id()))
//                .findFirst()
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }
}
