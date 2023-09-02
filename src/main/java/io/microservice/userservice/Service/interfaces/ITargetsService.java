package io.microservice.userservice.Service.interfaces;

import io.microservice.userservice.entities.Targets;

import java.util.List;

public interface ITargetsService {
    Targets createTarget(Targets target);
    List<Targets> getAllTargets();
    Targets getTargetById(Long id);
    Targets updateTarget(Targets target);
    void deleteTarget(Long id);
}

