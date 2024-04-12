package zoeque.odin.tool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zoeque.odin.system.domain.repository.OdinSystemRepository;
import zoeque.odin.term.domain.repository.TermRepository;

@Service
public class DatabaseDropService {
  @Autowired
  OdinSystemRepository odinSystemRepository;
  @Autowired
  TermRepository termRepository;

  public void deleteAll() {
    odinSystemRepository.deleteAll();
    termRepository.deleteAll();
  }
}
