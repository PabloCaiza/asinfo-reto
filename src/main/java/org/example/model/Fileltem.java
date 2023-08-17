package org.example.model;


import lombok.*;


@Getter
@Setter
@ToString
public class Fileltem extends Item{
    private String routerLink;

    public Fileltem(String label, String routerLink) {
        super(label);
        this.routerLink = routerLink;
    }




}
