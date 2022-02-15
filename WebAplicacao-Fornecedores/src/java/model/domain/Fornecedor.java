package model.domain;

public class Fornecedor {
    private int fornecedorID;
    private String nomeFantasia;  
    private String razaoSocial;   
    private String CNPJ;    
    private String cidade; 
    private String regiao;
    
        
    public Fornecedor() {
    }
    
    public int getFornecedorID() {
        return fornecedorID;
    }

    public void setFornecedorID(int fornecedorID) {
        this.fornecedorID = fornecedorID;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

}
