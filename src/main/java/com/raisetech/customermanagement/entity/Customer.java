package com.raisetech.customermanagement.entity;

import lombok.*;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class Customer {

    private int id;

    private String name;

    private int age;

    private String site;

    private String staff;
}
