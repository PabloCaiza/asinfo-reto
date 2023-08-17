package org.example.model;

import lombok.*;

@Getter
@Setter
@ToString
public class Item {
    private String label;

    public Item(String label) {
        this.label = label;
    }
}
