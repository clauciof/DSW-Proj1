/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author clauc
 */
public class SalaTeatro {
    
    
 private String email;
 private String senha;
 private String cidade;
 private String nome;
 private String CNPJ;
 
 public SalaTeatro(String email, String senha, String cidade, String nome, String CNPJ) {
    this.email = email;	 
    this.senha = senha;
    this.cidade = cidade;
    this.nome = nome;
    this.CNPJ = CNPJ;
 }

 public String getEmail() {
 return email;
 }
 public void setEmail(String email) {
 this.email = email;
 }
 public String getSenha() {
 return senha;
 }
 public void setSenha(String senha) {
 this.senha = senha;
 }
 public String getcidade() {
 return cidade;
 }
 public void setcidade(String cidade) {
 this.cidade = cidade;
 }
 public String getNome() {
 return nome;
 }
 public void setNome(String nome) {
 this.nome = nome;
 }

 public String getCNPJ() {
 return CNPJ;
 }
 public void setCNPJ(String CNPJ) {
 this.CNPJ = CNPJ;
 }
    
    
    
    
}
