package zoeque.odin.domain.system.entity;

import io.vavr.control.Try;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * The entity class to contains the setting of Odin system.
 */
@Entity
@Slf4j
@Getter
@NoArgsConstructor
@Table(name = "odin_system")
public class OdinSystem {
  @Id
  @Getter
  @GeneratedValue(strategy = GenerationType.AUTO)
  long identifier;

  Boolean randomFlag;
  Boolean memorizedFlag;
  Integer listSize;
  Integer listIndex;

  public OdinSystem(Boolean randomFlag,
                    Boolean memorizedFlag,
                    Integer listSize,
                    Integer listIndex) {
    setRandomFlag(randomFlag);
    setMemorizedFlag(memorizedFlag);
    setListSize(listSize);
    setListIndex(listIndex);
  }

  private void setRandomFlag(Boolean randomFlag) {
    if (randomFlag == null) {
      throw new IllegalArgumentException("random flag must not be null");
    }
    this.randomFlag = randomFlag;
  }

  private void setMemorizedFlag(Boolean memorizedFlag) {
    if (memorizedFlag == null) {
      throw new IllegalArgumentException("Studied flag must not be null");
    }
    this.memorizedFlag = memorizedFlag;
  }

  private void setListSize(Integer listSize) {
    if (listSize == null) {
      throw new IllegalArgumentException("List size must not be null");
    } else if (listSize <= 0 || listSize > 10) {
      throw new IllegalArgumentException("List size is too small or large:" + listSize);
    }
    this.listSize = listSize;
  }

  private void setListIndex(Integer listIndex) {
    if (listIndex == null) {
      throw new IllegalArgumentException("List index must not be null");
    }
    this.listIndex = listIndex;
  }

  /**
   * Reset the index to the zero.
   *
   * @return updated instance of {@link OdinSystem}.
   */
  public Try<OdinSystem> resetIndex() {
    this.listIndex = 0;
    return Try.success(this);
  }

  /**
   * Set start index of the all words list.
   *
   * @param index the start index of the list.
   * @return {@link OdinSystem} with updated index.
   */
  public Try<OdinSystem> updateIndex(Integer index) {
    try {
      setListIndex(index);
      return Try.success(this);
    } catch (Exception e) {
      return Try.failure(e);
    }
  }

  public Try<OdinSystem> edit(Boolean randomFlag,
                              Boolean memorizedFlag,
                              Integer listSize,
                              Integer listIndex) {
    try {
      setRandomFlag(randomFlag);
      setMemorizedFlag(memorizedFlag);
      setListSize(listSize);
      setListIndex(listIndex);
      return Try.success(this);
    } catch (Exception e) {
      return Try.failure(e);
    }
  }
}
