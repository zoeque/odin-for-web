package zoeque.odin.term.usecase;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import zoeque.odin.term.domain.entity.Term;
import zoeque.odin.term.domain.factory.TermFactory;
import zoeque.odin.term.domain.repository.TermRepository;

/**
 * The service class to handle {@link Term}.
 */
@Slf4j
@Service
public class TermService {
  TermRepository repository;
  TermFactory factory;
}
