package zoeque.odin.system.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The Data transfer object
 */
@Getter
@JsonDeserialize(as = OdinSystemDto.class)
@AllArgsConstructor
public class OdinSystemDto {
  Boolean randomFlag;
  Boolean memorizedFlag;
  Integer listSize;
  Integer listIndex;
}
