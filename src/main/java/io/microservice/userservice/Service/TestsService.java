package io.microservice.userservice.Service;

import io.microservice.userservice.repositories.TestsRepository;
import io.microservice.userservice.Service.interfaces.ITestsService;
import io.microservice.userservice.entities.Tests;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestsService implements ITestsService {



    @Autowired
    TestsRepository testsRepository;

    @Override
    public Tests createTests(Tests tests) {
        return testsRepository.save(tests);
    }

    @Override
    public List<Tests> getAllTests() {
        return testsRepository.findAll();
    }

    @Override
    public Tests getTestsById(Long id) {
        return testsRepository.findById(id).orElse(null);
    }

    @Override
    public Tests updateTests(Tests tests) {
        return testsRepository.save(tests);
    }

    @Override
    public void deleteTests(Long id) {
        testsRepository.deleteById(id);
    }
}
