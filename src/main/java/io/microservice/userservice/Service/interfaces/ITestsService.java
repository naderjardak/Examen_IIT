package io.microservice.userservice.Service.interfaces;

import io.microservice.userservice.entities.Tests;

import java.util.List;

public interface ITestsService {
    Tests createTests(Tests tests);
    List<Tests> getAllTests();
    Tests getTestsById(Long id);
    Tests updateTests(Tests tests);
    void deleteTests(Long id);
}
