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
public class Promocao {
    
  private String CNPJ;
 private String senha;
 private String endereco;
 private String nome_peca;
 private String preco;
 private String data_peca;
 private String horario;
 
 public Promocao(String CNPJ, String senha, String endereco, String nome_peca, String preco) {
 this.CNPJ = CNPJ;	 
 this.senha = senha;
 this.endereco = endereco;
 this.nome_peca = nome_peca;
 this.preco = preco;
 }
 
 public String getData (){
	return data_peca;
}

 public void setData (String data_peca){
	this.data_peca = data_peca;
}
 public String getHorario (){
	return horario;
}

 public void setHorario (String horario){
	this.horario = horario;
}



 public String getCNPJ() {
 return CNPJ;
 }
 public void setCNPJ(String CNPJ) {
 this.CNPJ = CNPJ;
 }
 public String getSenha() {
 return senha;
 }
 public void setSenha(String senha) {
 this.senha = senha;
 }
 public String getEndereco() {
 return endereco;
 }
 public void setEndereco(String endereco) {
 this.endereco = endereco;
 }
 public String getnome_peca() {
 return nome_peca;
 }
 public void setnome_peca(String nome_peca) {
 this.nome_peca = nome_peca;
 }

 public String getPreco() {
 return preco;
 }
 public void setPreco(String preco) {
 this.preco = preco;
 }
    

}
