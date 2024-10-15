package br.com.local.ecotech.placeholder;

public class EcoPontoModel {

    public String bairro;
    public String nome;
    public byte[] foto;
    public String cep;
    public String logradouro;
    public String numResid;
    public String telefone;
    public String horarioFunc;

    public EcoPontoModel(String bairro, String nome, byte[] foto, String cep, String logradouro, String numResid, String telefone, String horarioFunc){
        this.bairro = bairro;
        this.nome = nome;
        this.foto = foto;
        this.cep = cep;
        this.logradouro = logradouro;
        this.numResid = numResid;
        this.telefone = telefone;
        this.horarioFunc = horarioFunc;

    }

}
