/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Alunos
 */
public class Usuario {
    private String nome;
//    private String dataNascimento;
    private String endereco;
    private String telefone;
    private Float nota1;
    private Float nota2;
    private Float nota3;
    private Float nota4;
    private Float media;
    private int id;

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the dataNascimento
//     */
//    public String getDataNascimento() {
//        return dataNascimento;
//    }
//
//    /**
//     * @param dataNascimento the dataNascimento to set
//     */
//    public void setDataNascimento(String dataNascimento) {
//        this.dataNascimento = dataNascimento;
//    }

    /**
     * @return the endereço
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereço to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

 

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nota1
     */
    public Float getNota1() {
        return nota1;
    }

    /**
     * @param nota1 the nota1 to set
     */
    public void setNota1(Float nota1) {
        this.nota1 = nota1;
    }

    /**
     * @return the nota2
     */
    public Float getNota2() {
        return nota2;
    }

    /**
     * @param nota2 the nota2 to set
     */
    public void setNota2(Float nota2) {
        this.nota2 = nota2;
    }

    /**
     * @return the nota3
     */
    public Float getNota3() {
        return nota3;
    }

    /**
     * @param nota3 the nota3 to set
     */
    public void setNota3(Float nota3) {
        this.nota3 = nota3;
    }

    /**
     * @return the nota4
     */
    public Float getNota4() {
        return nota4;
    }

    /**
     * @param nota4 the nota4 to set
     */
    public void setNota4(Float nota4) {
        this.nota4 = nota4;
    }

    /**
     * @return the media
     */
    public Float getMedia() {
        return media;
    }

    /**
     * @param media the media to set
     */
    public void setMedia(Float media) {
        this.media = media;
    }
}
