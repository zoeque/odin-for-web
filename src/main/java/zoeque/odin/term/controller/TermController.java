package zoeque.odin.term.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zoeque.odin.term.application.TermService;
import zoeque.odin.term.domain.entity.Term;
import zoeque.odin.term.dto.TermDto;

/**
 * The controller class to handle Term instances.
 */
@RestController
@RequestMapping("term")
@CrossOrigin(origins = "*")
public class TermController {
  TermService service;

  public TermController(TermService service) {
    this.service = service;
  }

  /**
   * Create new {@link Term} in the database.
   *
   * @param dto The full fields of {@link TermDto}
   * @return REST response with created instance.
   */
  @PostMapping("/create")
  public ResponseEntity create(@RequestBody TermDto dto) {
    try {
      TermDto termDto = service.create(dto).get();
      return ResponseEntity.ok(termDto);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e);
    }
  }

  /**
   * The REST gateway to update the {@link Term} in DB.
   *
   * @param dto The full fields by JSON style
   * @return REST response with the instance of {@link TermDto}
   */
  @PostMapping("/edit")
  public ResponseEntity update(@RequestBody TermDto dto) {
    try {
      TermDto termDto = service.update(dto).get();
      return ResponseEntity.ok(termDto);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e);
    }
  }

  /**
   * The REST gateway to delete {@link Term} in the Database.
   *
   * @param dto The full set of the {@link TermDto} with JSON style.
   * @return REST response with the JSON of {@link TermDto}
   */
  @PostMapping("/delete")
  public ResponseEntity delete(@RequestBody TermDto dto) {
    try {
      TermDto termDto = service.delete(dto).get();
      return ResponseEntity.ok(termDto);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e);
    }
  }
}
