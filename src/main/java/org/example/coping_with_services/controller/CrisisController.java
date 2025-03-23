package org.example.coping_with_services.controller;

import org.example.coping_with_services.model.CrisisDescription;
import org.example.coping_with_services.model.CrisisResponseStep;
import org.example.coping_with_services.model.UserCrisisPlan;
import org.example.coping_with_services.repositories.UserCrisisPlanRepository;
import org.example.coping_with_services.services.CrisisDescriptionService;
import org.example.coping_with_services.services.CrisisResponseService;
import org.example.coping_with_services.config.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/crisis")
public class CrisisController {

    @Autowired
    private CrisisDescriptionService crisisDescriptionService;

    @Autowired
    private CrisisResponseService crisisResponseService;

    @Autowired
    private UserCrisisPlanRepository userCrisisPlanRepository;

    @Autowired
    private JwtUtil jwtUtil;

    private void validateToken(String token) {
        if (!jwtUtil.validateToken(token)) {
            throw new RuntimeException("Invalid JWT Token");
        }
    }

    @GetMapping("/descriptions")
    public List<CrisisDescription> getCrisisDescriptions(@RequestHeader("Authorization") String token) {
        validateToken(token);
        return crisisDescriptionService.getCrisisDescriptions();
    }

    @GetMapping("/steps")
    public List<CrisisResponseStep> getCrisisSteps(@RequestHeader("Authorization") String token) {
        validateToken(token);
        return crisisResponseService.getCrisisSteps();
    }

    @PostMapping("/save-plan")
    public ResponseEntity<String> saveCrisisPlan(@RequestHeader("Authorization") String token, @RequestBody UserCrisisPlan plan) {
        validateToken(token);
        crisisResponseService.saveUserCrisisPlan(plan);
        return ResponseEntity.ok("Crisis Plan Saved");
    }

    @GetMapping("/get-plan/{userDummyId}")
    public ResponseEntity<UserCrisisPlan> getUserCrisisPlan(@RequestHeader("Authorization") String token, @PathVariable String userDummyId) {
        validateToken(token);
        return userCrisisPlanRepository.findByUserDummyId(userDummyId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
