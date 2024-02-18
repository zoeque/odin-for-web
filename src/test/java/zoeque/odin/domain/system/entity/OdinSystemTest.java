package zoeque.odin.domain.system.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class OdinSystemTest {
  @Test
  public void givenTooLargeListSize_throwsException() {
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      OdinSystem odinSystem = new OdinSystem(false, false, 1000, 0);
    });
  }

  @Test
  public void givenTooSmallListSize_throwsException() {
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      OdinSystem odinSystem = new OdinSystem(false, false, 0, 0);
    });
  }
}
