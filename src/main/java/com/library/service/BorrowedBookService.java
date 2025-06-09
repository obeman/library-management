package com.library.service;

import com.library.dto.BorrowedBookDTO;
import com.library.entity.Book;
import com.library.entity.BorrowedBook;
import com.library.entity.Member;
import com.library.repository.BookRepository;
import com.library.repository.BorrowedBookRepository;
import com.library.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class BorrowedBookService {

    @Autowired
    private BorrowedBookRepository borrowedBookRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private MemberRepository memberRepository;

    public BorrowedBookDTO createBorrowedBook(BorrowedBookDTO borrowedBookDTO) {
        Book book = bookRepository.findById(borrowedBookDTO.getBookId())
                .orElseThrow(() -> new RuntimeException("Book not found"));
        Member member = memberRepository.findById(borrowedBookDTO.getMemberId())
                .orElseThrow(() -> new RuntimeException("Member not found"));

        BorrowedBook borrowedBook = new BorrowedBook();
        borrowedBook.setBook(book);
        borrowedBook.setMember(member);
        borrowedBook.setBorrowDate(borrowedBookDTO.getBorrowDate());
        borrowedBook.setReturnDate(borrowedBookDTO.getReturnDate());

        BorrowedBook savedBorrowedBook = borrowedBookRepository.save(borrowedBook);
        return convertToDTO(savedBorrowedBook);
    }

    public BorrowedBookDTO updateBorrowedBook(Long id, BorrowedBookDTO borrowedBookDTO) {
        BorrowedBook borrowedBook = borrowedBookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Borrowed book not found"));
        Book book = bookRepository.findById(borrowedBookDTO.getBookId())
                .orElseThrow(() -> new RuntimeException("Book not found"));
        Member member = memberRepository.findById(borrowedBookDTO.getMemberId())
                .orElseThrow(() -> new RuntimeException("Member not found"));

        borrowedBook.setBook(book);
        borrowedBook.setMember(member);
        borrowedBook.setBorrowDate(borrowedBookDTO.getBorrowDate());
        borrowedBook.setReturnDate(borrowedBookDTO.getReturnDate());

        BorrowedBook updatedBorrowedBook = borrowedBookRepository.save(borrowedBook);
        return convertToDTO(updatedBorrowedBook);
    }

    public void deleteBorrowedBook(Long id) {
        borrowedBookRepository.deleteById(id);
    }

    public List<BorrowedBookDTO> getAllBorrowedBooks() {
        return borrowedBookRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public BorrowedBookDTO getBorrowedBookById(Long id) {
        BorrowedBook borrowedBook = borrowedBookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Borrowed book not found"));
        return convertToDTO(borrowedBook);
    }

    public List<BorrowedBookDTO> searchBorrowedBooks(String title, String memberName, LocalDate borrowDate) {
        return borrowedBookRepository.searchBorrowedBooks(title, memberName, borrowDate).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private BorrowedBookDTO convertToDTO(BorrowedBook borrowedBook) {
        BorrowedBookDTO dto = new BorrowedBookDTO();
        dto.setId(borrowedBook.getId());
        dto.setBookId(borrowedBook.getBook().getId());
        dto.setBookTitle(borrowedBook.getBook().getTitle());
        dto.setMemberId(borrowedBook.getMember().getId());
        dto.setMemberName(borrowedBook.getMember().getName());
        dto.setBorrowDate(borrowedBook.getBorrowDate());
        dto.setReturnDate(borrowedBook.getReturnDate());
        return dto;
    }
} 