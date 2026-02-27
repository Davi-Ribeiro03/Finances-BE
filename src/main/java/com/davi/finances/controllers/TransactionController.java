package com.davi.finances.controllers;

import com.davi.finances.dtos.transaction.GetAllResponseDto;
import com.davi.finances.enums.Categories;
import com.davi.finances.enums.transactionsType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    List<GetAllResponseDto> transactions = new ArrayList<>(List.of(
            new GetAllResponseDto(
                    1L,
                    "Salário",
                    BigDecimal.valueOf(3500),
                    new Date(),
                    "Salário mensal",
                    Categories.SALARY,
                    new Date(),
                    transactionsType.entry,
                    1L
            ),
            new GetAllResponseDto(
                    2L,
                    "Supermercado",
                    BigDecimal.valueOf(450.75),
                    new Date(),
                    "Compras do mês",
                    Categories.FOOD,
                    new Date(),
                    transactionsType.expense,
                    1L
            ),
            new GetAllResponseDto(
                    3L,
                    "Internet",
                    BigDecimal.valueOf(120.00),
                    new Date(),
                    "Plano mensal de internet",
                    Categories.ENTERTAINMENT,
                    new Date(),
                    transactionsType.expense,
                    1L
            )
    ));

    @GetMapping()
    public ResponseEntity<List<GetAllResponseDto>> GetAll(){
        return ResponseEntity.ok(transactions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetAllResponseDto> GetAll(@PathVariable Long id){
        return transactions
                .stream()
                .filter(t -> t.id().equals(id))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity<List<GetAllResponseDto>> AddTransaction(@RequestBody GetAllResponseDto transaction){
        transactions.add(transaction);

        return ResponseEntity.ok(transactions);
    }

    @PutMapping()
    public ResponseEntity<GetAllResponseDto> EditTransaction(@RequestBody GetAllResponseDto transaction){
        transactions.remove(transaction.id().intValue()-1);
        transactions.add( transaction);

        return transactions
                .stream()
                .filter(t -> t.id().equals(transaction.id()))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
