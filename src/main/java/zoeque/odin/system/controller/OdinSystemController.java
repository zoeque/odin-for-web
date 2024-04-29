package zoeque.odin.system.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zoeque.odin.system.domain.entity.OdinSystem;
import zoeque.odin.system.dto.OdinSystemDto;
import zoeque.odin.system.application.OdinSystemService;

/**
 * The controller class to handle odin system.
 */
@RestController
@RequestMapping("system")
@CrossOrigin(origins = "*")
public class OdinSystemController {
  OdinSystemService service;

  public OdinSystemController(OdinSystemService service) {
    this.service = service;
  }

  @PostMapping("/create")
  public ResponseEntity create() {
    try {
      OdinSystem odinSystem = service.create().get();
      return ResponseEntity.ok(odinSystem);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e);
    }
  }

  @PostMapping("/edit")
  public ResponseEntity edit(@RequestBody OdinSystemDto dto) {
    try {
      OdinSystem odinSystem = service.edit(dto).get();
      return ResponseEntity.ok(odinSystem);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e);
    }
  }
}
