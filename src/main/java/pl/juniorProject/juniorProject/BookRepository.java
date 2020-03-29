package pl.juniorProject.juniorProject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.juniorProject.juniorProject.model.Book;

import javax.transaction.Transactional;

@Repository
public interface BookRepository extends JpaRepository <Book, Long> {
    @Transactional
    Long deleteBookById(Long id);
}
