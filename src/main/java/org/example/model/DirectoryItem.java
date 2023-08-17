package org.example.model;


import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
public class DirectoryItem extends Item{

    private List<Item> items;


    public DirectoryItem(String label, List<Item> items) {
        super(label);
        this.items = items;
    }
}
