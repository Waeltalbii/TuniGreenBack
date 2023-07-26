package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

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

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date creation_date ;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date expiration_date ;
    private String pictureUrl ;
    private Integer points ;
    @JsonIgnore
    @ManyToOne()
    private Partner partner ;
    @ManyToMany()
    private List<Appuser> appusers;

}
