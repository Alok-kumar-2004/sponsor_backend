package com.example.sponsor.Controller;

import com.example.sponsor.Model.sponsorModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.sponsor.Repository.sponsorRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping({"/api/v1"})
public class sponsorController {
    @Autowired
    private sponsorRepository sponsorRepository;

    public sponsorController(){}

    @CrossOrigin(origins = {"http://localhost:4200"})
    @GetMapping({"/sponsors"})
    public ResponseEntity<List<sponsorModel>> getAllSponsors() {
        List<sponsorModel> sponsors = this.sponsorRepository.findAll();
        return sponsors.isEmpty() ? ResponseEntity.status(HttpStatus.NO_CONTENT).build() : ResponseEntity.ok(sponsors);
    }

    @CrossOrigin(origins = {"http://localhost:4200"})
    @PostMapping({"/sponsors"})
    public sponsorModel createSponsor(@RequestBody sponsorModel sponsor) {
        System.out.println("Received Sponsor: " + sponsor);
        return this.sponsorRepository.save(sponsor);
    }

    @CrossOrigin(origins = {"http://localhost:4200"})
    @GetMapping({"/sponsors/{id}"})
    public ResponseEntity<sponsorModel> getSponsorById(@PathVariable Long id) {
        sponsorModel sponsor = this.sponsorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sponsor not found with id: " + id));
        return ResponseEntity.ok(sponsor);
    }

    @CrossOrigin(origins = {"http://localhost:4200"})
    @GetMapping({"/sponsors/event/{eventName}"})
    public ResponseEntity<List<sponsorModel>> getSponsorsByEventName(@PathVariable String eventName) {
        List<sponsorModel> sponsors = this.sponsorRepository.findByEventName(eventName);
        return sponsors.isEmpty() ? ResponseEntity.status(HttpStatus.NO_CONTENT).build() : ResponseEntity.ok(sponsors);
    }

    @CrossOrigin(origins = {"http://localhost:4200"})
    @PutMapping({"/sponsors/{id}"})
    public ResponseEntity<sponsorModel> updateSponsor(@PathVariable Long id, @RequestBody sponsorModel sponsorDetails) {
        sponsorModel sponsor = this.sponsorRepository.findById(id).orElseThrow(() -> new RuntimeException("Sponsor not found with id: " + id));
        sponsor.setSponsorName(sponsorDetails.getSponsorName());
        sponsor.setContactPerson(sponsorDetails.getContactPerson());
        sponsor.setEmail(sponsorDetails.getEmail());
        sponsor.setSponsorshipStatus(sponsorDetails.getSponsorshipStatus());
        sponsor.setContributionAmount(sponsorDetails.getContributionAmount());
        sponsor.setcontributionDate(sponsorDetails.getcontributionDate());
        sponsor.setContactNumber(sponsorDetails.getContactNumber());
        sponsor.setEventName(sponsorDetails.getEventName());
        sponsor.setOrganizationName(sponsorDetails.getOrganizationName());
        sponsorModel updatedSponsor = this.sponsorRepository.save(sponsor);
        return ResponseEntity.ok(updatedSponsor);
    }

    @CrossOrigin(origins = {"http://localhost:4200"})
    @DeleteMapping({"/sponsors/{id}"})
    public ResponseEntity<Map<String, Boolean>> deleteSponsor(@PathVariable Long id) {
        sponsorModel sponsor = this.sponsorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sponsor not found with id: " + id));
        this.sponsorRepository.delete(sponsor);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
