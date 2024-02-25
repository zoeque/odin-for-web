package zoeque.odin.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import zoeque.odin.domain.system.entity.OdinSystem;
import zoeque.odin.usecase.system.OdinSystemService;

@RestController
@CrossOrigin(origins = "*")
public class OdinSystemController {
  OdinSystemService service;

  public OdinSystemController(OdinSystemService service) {
    this.service = service;
  }

  @PostMapping("/system/create")
  public ResponseEntity create() {
    try {
      OdinSystem odinSystem = service.create().get();
      return ResponseEntity.ok(odinSystem);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e);
    }
  }
}
