package com.softlond.akdevmy.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document(collection = "Academy")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AcademyEntity {

    @Id
    private ObjectId id;

    private String name;

    private String nit;

    private String telephone;

    private String email;

    @Field("social_networks")
    private List<SocialNetwork> socialNetworks;

    private String imageUrl;

}
