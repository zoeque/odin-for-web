package zoeque.odin.term.domain.entity.valueobject;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
public class Word {
  String name;

  public Word(String name) {
    setName(name);
  }

  private void setName(String name) {
    if (name == null) {
      throw new IllegalArgumentException("Word must contains its name");
    }
    this.name = name;
  }
}
