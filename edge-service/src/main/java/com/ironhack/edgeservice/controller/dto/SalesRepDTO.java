package com.ironhack.edgeservice.controller.dto;

public class SalesRepDTO {
    private Long id;
    private String name;

    public SalesRepDTO() {
    }

    public SalesRepDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
