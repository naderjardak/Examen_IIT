package io.microservice.userservice.Service;

import io.microservice.userservice.repositories.TargetsRepository;
import io.microservice.userservice.Service.interfaces.ITargetsService;
import io.microservice.userservice.entities.Targets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TargetsService implements ITargetsService {



    @Autowired
    TargetsRepository targetRepository;

    @Override
    public Targets createTarget(Targets target) {
        return targetRepository.save(target);
    }

    @Override
    public List<Targets> getAllTargets() {
        return targetRepository.findAll();
    }

    @Override
    public Targets getTargetById(Long id) {
        return targetRepository.findById(id).orElse(null);
    }

    @Override
    public Targets updateTarget(Targets target) {
        return targetRepository.save(target);
    }

    @Override
    public void deleteTarget(Long id) {
        targetRepository.deleteById(id);
    }
}
