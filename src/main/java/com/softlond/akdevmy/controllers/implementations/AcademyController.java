package com.softlond.akdevmy.controllers.implementations;

import com.softlond.akdevmy.models.AcademyEntity;
import com.softlond.akdevmy.services.implementations.AcademyService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;


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
    public AcademyEntity getAcademyInfo(@PathVariable("id") String id) {
        return academyService.getAcademyById(id);

    }

    @PostMapping("/{id}/editar_perfil")
    public AcademyEntity SetAcademyInfo(@PathVariable("id") String id, @RequestBody AcademyEntity academyToUpdate) {
        return academyService.updateAcademy(id, academyToUpdate);
    }

}

