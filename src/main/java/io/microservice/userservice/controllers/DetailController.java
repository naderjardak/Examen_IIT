package io.microservice.userservice.controllers;
import io.microservice.userservice.Service.interfaces.IDetailService;
import io.microservice.userservice.entities.Detail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/details")
public class DetailController {


    @Autowired
    IDetailService iDetailService;

    @PostMapping
    public ResponseEntity<Detail> createDetail(@RequestBody Detail detail) {
        Detail createdDetail = iDetailService.createDetail(detail);
        return ResponseEntity.ok(createdDetail);
    }

    @GetMapping
    public ResponseEntity<List<Detail>> getAllDetails() {
        List<Detail> details = iDetailService.getAllDetails();
        return ResponseEntity.ok(details);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Detail> getDetailById(@PathVariable Long id) {
        return iDetailService.getDetailById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

   /* @PutMapping("/{id}")
    public ResponseEntity<Void> updateDetail(@PathVariable Long id, @RequestBody Detail detail) {
        // Ensure the correct ID is set
        detail.setId(id);

        // Call the service to update the detail
        iDetailService.updateDetail(detail);

        return ResponseEntity.noContent().build();
    }*/

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDetail(@PathVariable Long id) {
        iDetailService.deleteDetail(id);
        return ResponseEntity.noContent().build();
    }
}

