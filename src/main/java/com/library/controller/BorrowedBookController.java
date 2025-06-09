package com.library.controller;

import com.library.dto.BorrowedBookDTO;
import com.library.service.BorrowedBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/borrowed-books")
public class BorrowedBookController {

    @Autowired
    private BorrowedBookService borrowedBookService;

    @PostMapping
    public ResponseEntity<BorrowedBookDTO> createBorrowedBook(@RequestBody BorrowedBookDTO borrowedBookDTO) {
        return ResponseEntity.ok(borrowedBookService.createBorrowedBook(borrowedBookDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BorrowedBookDTO> updateBorrowedBook(@PathVariable Long id, @RequestBody BorrowedBookDTO borrowedBookDTO) {
        return ResponseEntity.ok(borrowedBookService.updateBorrowedBook(id, borrowedBookDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBorrowedBook(@PathVariable Long id) {
        borrowedBookService.deleteBorrowedBook(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<BorrowedBookDTO>> getAllBorrowedBooks() {
        return ResponseEntity.ok(borrowedBookService.getAllBorrowedBooks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BorrowedBookDTO> getBorrowedBookById(@PathVariable Long id) {
        return ResponseEntity.ok(borrowedBookService.getBorrowedBookById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<List<BorrowedBookDTO>> searchBorrowedBooks(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String memberName,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate borrowDate) {
        return ResponseEntity.ok(borrowedBookService.searchBorrowedBooks(title, memberName, borrowDate));
    }
} 