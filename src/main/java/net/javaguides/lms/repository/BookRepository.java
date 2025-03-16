package net.javaguides.lms.repository;

import net.javaguides.lms.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("SELECT b FROM Book b WHERE lower(b.title) LIKE lower(CONCAT('%', :search, '%')) OR lower(b.author) LIKE lower(CONCAT('%', :search, '%'))")
    List<Book> findByTitleOrAuthorContainingIgnoreCase(@Param("search") String search);
}
