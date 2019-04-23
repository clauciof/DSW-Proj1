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
 private String url;
 private String nome_peca;
 private String preco;
 private String data_peca;
 private String horario;
 
 public Promocao(String nome_peca, String url, String preco, String data_peca, String horario  ) {
 this.CNPJ = CNPJ;	 
 this.senha = senha;
 this.url = url;
 this.nome_peca = nome_peca;
 this.preco = preco;
 this.data_peca=data_peca;
 this.horario=horario;
 }

    public void setNome_peca(String nome_peca) {
        this.nome_peca = nome_peca;
    }

    public void setData_peca(String data_peca) {
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
 public String getUrl() {
 return url;
 }
 public void setUrl(String url) {
 this.url = url;
 }
 
 public String getNome_peca() {
        return nome_peca;
    }

 public String getData_peca() {
     return data_peca;
}
 
 public String getPreco() {
 return preco;
 }
 
 public void setPreco(String preco) {
 this.preco = preco;
 }
 
}
