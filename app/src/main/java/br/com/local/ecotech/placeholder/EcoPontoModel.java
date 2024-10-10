package br.com.local.ecotech.placeholder;

public class EcoPontoModel {

    public String bairro;
    public String nome;
    public byte[] foto;

    public EcoPontoModel(String bairro, String nome){
        this.bairro = bairro;
        this.nome = nome;
    }

    public EcoPontoModel(String bairro, String nome, byte[] foto){
        this.bairro = bairro;
        this.nome = nome;
        this.foto = foto;
    }

}
