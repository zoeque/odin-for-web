package zoeque.odin.domain.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import zoeque.odin.domain.system.entity.OdinSystem;

/**
 * The repository class for {@link OdinSystem}.
 */
@Repository
public interface OdinSystemRepository extends JpaRepository<OdinSystem, String>,
        JpaSpecificationExecutor<OdinSystem> {
}
