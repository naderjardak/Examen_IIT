package io.microservice.userservice.Service.interfaces;

import io.microservice.userservice.entities.Detail;

import java.util.List;
import java.util.Optional;

public interface IDetailService {
    Detail createDetail(Detail detail);
    List<Detail> getAllDetails();
    Optional<Detail> getDetailById(Long id);
    void updateDetail(Detail detail);
    void deleteDetail(Long id);
}
