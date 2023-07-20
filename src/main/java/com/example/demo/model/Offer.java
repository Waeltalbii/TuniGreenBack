package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "offer")
public class Offer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    private String name ;
    private String description ;
    private Date creation_date ;
    private Date expiration_date ;
    private String pictureUrl ;
    private Integer points ;
    @JsonIgnore
    @ManyToOne()
    private Partner partner ;
    @ManyToMany()
    private List<Appuser> appusers;

}
