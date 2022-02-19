package com.richards.store.model;

import com.richards.store.excepion.InvalidCpfException;

public class Cpf {

    private String cpf;

    public Cpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCpf() {
        return this.cpf;
    }
}
