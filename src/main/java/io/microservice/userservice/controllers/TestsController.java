package io.microservice.userservice.controllers;

import io.microservice.userservice.Service.interfaces.ITestsService;
import io.microservice.userservice.entities.Tests;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tests")
public class TestsController {



    @Autowired
    ITestsService iTestsService;

    @PostMapping
    public ResponseEntity<Tests> createTests(@RequestBody Tests tests) {
        Tests createdTests = iTestsService.createTests(tests);
        return ResponseEntity.ok(createdTests);
    }

    @GetMapping
    public ResponseEntity<List<Tests>> getAllTests() {
        List<Tests> tests = iTestsService.getAllTests();
        return ResponseEntity.ok(tests);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tests> getTestsById(@PathVariable Long id) {
        Tests tests = iTestsService.getTestsById(id);
        if (tests != null) {
            return ResponseEntity.ok(tests);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /*@PutMapping("/{id}")
    public ResponseEntity<Tests> updateTests(@PathVariable Long id, @RequestBody Tests tests) {
        Tests existingTests = iTestsService.getTestsById(id);
        if (existingTests != null) {
            tests.setId(id);
            Tests updatedTests = iTestsService.updateTests(tests);
            return ResponseEntity.ok(updatedTests);
        } else {
            return ResponseEntity.notFound().build();
        }
    }*/

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTests(@PathVariable Long id) {
        iTestsService.deleteTests(id);
        return ResponseEntity.noContent().build();
    }
}
