public class ArvoreNatalina extends Arvore {
    private int altura;

    public ArvoreNatalina(int id, String nome, double preco, int altura) {
        super(id, nome, preco);
        this.altura = altura;
    }

    public ArvoreNatalina() {
       
    }

  
    public void exibirInformacoes() {
        System.out.println("Árvore de Natal: " + nome + ", Altura: " + altura + " cm, Preço: R$" + preco);
    }

    
    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
}

