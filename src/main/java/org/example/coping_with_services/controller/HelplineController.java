package org.example.coping_with_services.controller;

import org.example.coping_with_services.model.Helpline;
import org.example.coping_with_services.services.HelplineService;
import org.example.coping_with_services.config.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/helplines")
public class HelplineController {

    @Autowired
    private HelplineService helplineService;

    @Autowired
    private JwtUtil jwtUtil;

    private void validateToken(String token) {
        if (!jwtUtil.validateToken(token)) {
            throw new RuntimeException("Invalid JWT Token");
        }
    }

    @GetMapping
    public List<Helpline> getHelplines(@RequestHeader("Authorization") String token) {
        validateToken(token);
        return helplineService.getAllHelplines();
    }
}
