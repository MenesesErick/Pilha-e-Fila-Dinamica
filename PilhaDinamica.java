package AtvAula5;

public class PilhaDinamica<T> {

    private No<T> topo;
    private int tamanho;

    public PilhaDinamica() {
        this.topo = null;
        this.tamanho = 0;
    }

    public void push(T elemento) {
        No<T> novoNo = new No<>(elemento);
        if (topo == null) {
            topo = novoNo;
        } else {
            novoNo.setProximo(topo);
            topo = novoNo;
        }
        tamanho++;
    }

    public T pop() {
        if (!estaVazia()) {
            T elementoRemovido = topo.getElemento();
            topo = topo.getProximo();
            tamanho--;
            return elementoRemovido;
        }
        return null;
    }

    public int tamanho() {
        return tamanho;
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public void imprimir() {
        No<T> atual = topo;
        while (atual != null) {
            System.out.println(atual.getElemento());
            atual = atual.getProximo();
        }
    }

    public static void main(String[] args) {
        PilhaDinamica<Integer> pilha = new PilhaDinamica<>();

        pilha.push(10);
        pilha.push(20);
        pilha.pop();
        pilha.push(30);
        pilha.push(40);
        pilha.pop();

        System.out.println("Tamanho da pilha: " + pilha.tamanho());
        System.out.println("A pilha está vazia? " + pilha.estaVazia());
        pilha.imprimir();
    }
}