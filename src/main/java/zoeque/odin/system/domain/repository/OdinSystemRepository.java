package zoeque.odin.system.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import zoeque.odin.system.domain.entity.OdinSystem;

/**
 * The repository class for {@link OdinSystem}.
 */
@Repository
public interface OdinSystemRepository extends JpaRepository<OdinSystem, String>,
        JpaSpecificationExecutor<OdinSystem> {
}
