package com.softlond.akdevmy.controllers.implementations;

import com.softlond.akdevmy.models.AcademyEntity;
import com.softlond.akdevmy.services.implementations.AcademyService;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/academy")
public class AcademyController {

    private AcademyService academyService;

    @Autowired
    public AcademyController(AcademyService academyService){
        this.academyService = academyService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AcademyEntity> getAcademyInfo(@PathVariable("id") String id) {
        return ResponseEntity.ok(academyService.getAcademyById(id));

    }

    @PostMapping("/{id}/editar_perfil")
    public ResponseEntity<AcademyEntity> SetAcademyInfo(@PathVariable("id") String id, @RequestBody AcademyEntity academyToUpdate) {
        return ResponseEntity.ok(academyService.updateAcademy(id, academyToUpdate));
    }

}

