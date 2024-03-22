package zoeque.odin.term.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import zoeque.odin.term.domain.entity.Term;

/**
 * The repository class to CRUD handle for the {@link Term}.
 */
@Repository
public interface TermRepository extends JpaRepository<Term, String>,
        JpaSpecificationExecutor<Term> {
}
