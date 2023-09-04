package io.microservice.userservice.Service;

import io.microservice.userservice.entities.Detail;
import io.microservice.userservice.repositories.DetailRepository;
import io.microservice.userservice.Service.interfaces.IDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetailService implements IDetailService {



    @Autowired
    DetailRepository detailRepository;

    @Override
    public Detail createDetail(Detail detail) {
        return detailRepository.save(detail);
    }

    @Override
    public List<Detail> getAllDetails() {
        return detailRepository.findAll();
    }

    @Override
    public Optional<Detail> getDetailById(Long id) {
        return detailRepository.findById(id);
    }

    @Override
    public void updateDetail(Detail detail) {
        detailRepository.save(detail);
    }

    @Override
    public void deleteDetail(Long id) {
        detailRepository.deleteById(id);
    }
}

