package com.raisetech.customermanagement.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class CreateForm {

    private int id;

    @NotBlank
    private String name;

    @NotNull
    private int age;

    @NotBlank
    private String site;

    @NotBlank
    private String staff;

}
