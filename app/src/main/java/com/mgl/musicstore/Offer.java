package com.mgl.musicstore;

/**
 * Created by Miguel on 25/11/2017.
 */

class Offer {
    private int id;
    private String nome;
    private String email;
    private String telefone;
    private int instrument_id;

    public Offer(int id, String nome, String email, String telefone, int instrument_id) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.instrument_id = instrument_id;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInstrument_id() {
        return instrument_id;
    }

    public void setInstrument_id(int instrument_id) {
        this.instrument_id = instrument_id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

}
