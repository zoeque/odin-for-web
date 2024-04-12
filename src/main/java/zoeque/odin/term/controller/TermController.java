package zoeque.odin.term.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zoeque.odin.term.dto.TermDto;
import zoeque.odin.term.usecase.TermService;

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

  @PostMapping("/create")
  public ResponseEntity create(TermDto dto) {
    try {
      TermDto termDto = service.create(dto).get();
      return ResponseEntity.ok(termDto);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e);
    }
  }
}
