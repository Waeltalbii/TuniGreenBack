package com.example.demo.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class OffreDTO {
    private String name ;
    private String description ;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date creation_date ;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date expiration_date ;
    private String pictureUrl ;
    private Integer points ;
}
