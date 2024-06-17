public class ArvoreFrutifera extends Arvore {
    private String frutaProduzida;

    public ArvoreFrutifera(int id, String nome, double preco, String frutaProduzida) {
        super(id, nome, preco);
        this.frutaProduzida = frutaProduzida;
    }

    public ArvoreFrutifera() {
        
    }

    
    public void exibirInformacoes() {
        System.out.println("Árvore Frutífera: " + nome + ", Fruta: " + frutaProduzida + ", Preço: R$" + preco);
    }

    
    public String getFrutaProduzida() {
        return frutaProduzida;
    }

    public void setFrutaProduzida(String frutaProduzida) {
        this.frutaProduzida = frutaProduzida;
    }
}
