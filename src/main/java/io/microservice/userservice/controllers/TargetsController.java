package io.microservice.userservice.controllers;

import io.microservice.userservice.Service.interfaces.ITargetsService;
import io.microservice.userservice.entities.Targets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/targets")
public class TargetsController {



    @Autowired
    ITargetsService iTargetsService;

    @PostMapping
    public ResponseEntity<Targets> createTarget(@RequestBody Targets target) {
        Targets createdTarget = iTargetsService.createTarget(target);
        return ResponseEntity.ok(createdTarget);
    }

    @GetMapping
    public ResponseEntity<List<Targets>> getAllTargets() {
        List<Targets> targets = iTargetsService.getAllTargets();
        return ResponseEntity.ok(targets);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Targets> getTargetById(@PathVariable Long id) {
        Targets target = iTargetsService.getTargetById(id);
        if (target != null) {
            return ResponseEntity.ok(target);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

 /*   @PutMapping("/{id}")
    public ResponseEntity<Targets> updateTarget(@PathVariable Long id, @RequestBody Targets target) {
        Targets existingTarget = iTargetsService.getTargetById(id);
        if (existingTarget != null) {
            target.setId(id);
            Targets updatedTarget = iTargetsService.updateTarget(target);
            return ResponseEntity.ok(updatedTarget);
        } else {
            return ResponseEntity.notFound().build();
        }
    }*/

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTarget(@PathVariable Long id) {
        iTargetsService.deleteTarget(id);
        return ResponseEntity.noContent().build();
    }
}