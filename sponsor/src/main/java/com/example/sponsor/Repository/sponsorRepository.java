package com.example.sponsor.Repository;

import com.example.sponsor.Model.sponsorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface sponsorRepository extends JpaRepository<sponsorModel, Long> {
    List<sponsorModel> findByEventName(String eventName);
}
