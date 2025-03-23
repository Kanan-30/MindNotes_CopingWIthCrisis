package org.example.coping_with_services.controller;
import org.example.coping_with_services.model.CrisisDescription;
import org.example.coping_with_services.model.CrisisResponseStep;
import org.example.coping_with_services.model.UserCrisisPlan;
import org.example.coping_with_services.repositories.UserCrisisPlanRepository;
import org.example.coping_with_services.services.CrisisDescriptionService;
import org.example.coping_with_services.services.CrisisResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/crisis")
public class CrisisController {
    @Autowired
    private CrisisDescriptionService crisisDescriptionService;
    @Autowired
    private CrisisResponseService crisisResponseService;

    @GetMapping("/descriptions")
    public List<CrisisDescription> getCrisisDescriptions() { return crisisDescriptionService.getCrisisDescriptions(); }

    @GetMapping("/steps")
    public List<CrisisResponseStep> getCrisisSteps() { return crisisResponseService.getCrisisSteps(); }


    @PostMapping("/save-plan")
    public ResponseEntity<String> saveCrisisPlan(@RequestBody UserCrisisPlan plan) {
        crisisResponseService.saveUserCrisisPlan(plan);
        return ResponseEntity.ok("Crisis Plan Saved");
    }

    @Autowired
    private UserCrisisPlanRepository userCrisisPlanRepository;
    @GetMapping("/get-plan/{userDummyId}")
    public ResponseEntity<UserCrisisPlan> getUserCrisisPlan(@PathVariable String userDummyId) {
        return userCrisisPlanRepository.findByUserDummyId(userDummyId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}