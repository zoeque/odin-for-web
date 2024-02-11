package zoeque.odin.tool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zoeque.odin.domain.system.repository.OdinSystemRepository;

@Service
public class DatabaseDropService {
  @Autowired
  OdinSystemRepository odinSystemRepository;

  public void deleteAll() {
    odinSystemRepository.deleteAll();
  }
}
