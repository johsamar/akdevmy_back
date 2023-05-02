package com.softlond.akdevmy.services.implementations;
import com.softlond.akdevmy.models.AcademyEntity;
import com.softlond.akdevmy.models.SocialNetwork;
import com.softlond.akdevmy.repositories.contracts.AcademyRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class AcademyService {

    private final AcademyRepository academyRepository;

    @Autowired
    public AcademyService(AcademyRepository academyRepository) {
        this.academyRepository = academyRepository;
    }

    /** Metodo que devuelve la informacion de la academia por id*/
    public AcademyEntity getAcademyById(String id) {
        ObjectId objectId = new ObjectId(id);
        Optional<AcademyEntity> optionalAcademy = academyRepository.findById(objectId);
        return optionalAcademy.orElse(null);
    }

    /** Metodo que actualiza la informacion de la academia*/
    public AcademyEntity updateAcademy(String id, AcademyEntity updatedAcademy) {
        ObjectId objectId = new ObjectId(id);
        Optional<AcademyEntity> optionalAcademy = academyRepository.findById(objectId);
        if (optionalAcademy.isPresent()) {
            AcademyEntity existingAcademy = optionalAcademy.get();
            return modifiedAcademy(existingAcademy,updatedAcademy);
        }
        return null;
    }


    /** Metodo de apoyo para modificar la academia. recibe de parametro la academia existente en la bdd y la peticion tipo json
     * con la informacion modificada*/
    private AcademyEntity modifiedAcademy(AcademyEntity existingAcademy, AcademyEntity updatedAcademy){
        //Actualizar los campos del documento existente con los valores del objeto actualizado
        existingAcademy.setName(updatedAcademy.getName());
        existingAcademy.setNit(updatedAcademy.getNit());
        existingAcademy.setTelephone(updatedAcademy.getTelephone());
        existingAcademy.setEmail(updatedAcademy.getEmail());
//        updatedSocialNetworks(existingAcademy,updatedAcademy);
        existingAcademy.setImageUrl(updatedAcademy.getImageUrl());
        return academyRepository.save(existingAcademy);
    }

    // TODO: 02/05/2023  Hacer Funcionalidad para modificar la lista que contiene los tipos e informacion de las redes sociales, Corregir la excepcion nullPointer exception

//    private void updatedSocialNetworks(AcademyEntity existingAcademy, AcademyEntity updatedAcademy){
//        List<SocialNetwork> currentSocialNetworkList = new ArrayList<>(existingAcademy.getSocialNetworks());
//        List<SocialNetwork> socialNetworkListToUpdate = new ArrayList<>(updatedAcademy.getSocialNetworks());
//
//        List<SocialNetwork> socialNetworksListFinal = new ArrayList<>(currentSocialNetworkList);
//        socialNetworksListFinal.addAll(socialNetworkListToUpdate);
//        Set<SocialNetwork> set = new HashSet<>(socialNetworksListFinal);
//        socialNetworksListFinal.clear();
//        socialNetworksListFinal.addAll(set);
//    }

}
