package zoeque.odin.term.domain.entity.valueobject;

import lombok.Getter;

/**
 * The state that the word is memorized or not
 */
public enum MemorizedState {
  MEMORIZED("memorized"),
  NOT_MEMORIZED("not_memorized");
  @Getter
  String state;

  MemorizedState(String state) {
    this.state = state;
  }
}
