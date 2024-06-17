import java.util.ArrayList;
import java.util.List;

public class LojaArvores {
    private List<Arvore> arvores;

    public LojaArvores() {
        arvores = new ArrayList<>();
    }

    
    public void cadastrarArvore(Arvore arvore) {
        arvores.add(arvore);
    }

    public void listarArvores() {
        for (Arvore arvore : arvores) {
            arvore.exibirInformacoes();
        }
    }

    public Arvore buscarArvorePorId(int id) {
        for (Arvore arvore : arvores) {
            if (arvore.getId() == id) {
                return arvore;
            }
        }
        return null; 
    }

    public void excluirArvore(int id) {
        arvores.removeIf(arvore -> arvore.getId() == id);
    }

    public void editarArvore(int id, Arvore novaArvore) {
        for (int i = 0; i < arvores.size(); i++) {
            if (arvores.get(i).getId() == id) {
                arvores.set(i, novaArvore);
                break;
            }
        }
    }
}
