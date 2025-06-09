package com.library.repository;

import com.library.entity.BorrowedBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface BorrowedBookRepository extends JpaRepository<BorrowedBook, Long> {
    
    @Query("SELECT bb FROM BorrowedBook bb " +
           "JOIN bb.book b " +
           "JOIN bb.member m " +
           "WHERE LOWER(b.title) LIKE LOWER(CONCAT('%', :title, '%')) " +
           "OR LOWER(m.name) LIKE LOWER(CONCAT('%', :memberName, '%')) " +
           "OR bb.borrowDate = :borrowDate")
    List<BorrowedBook> searchBorrowedBooks(
        @Param("title") String title,
        @Param("memberName") String memberName,
        @Param("borrowDate") LocalDate borrowDate
    );
} 