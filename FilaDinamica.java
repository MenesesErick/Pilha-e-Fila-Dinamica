package AtvAula5;

public class FilaDinamica<T> {

    private No<T> topo;
    private No<T> tras;
    private int tamanho;

    public FilaDinamica() {
        this.topo = null;
        this.tras = null;
        this.tamanho = 0;
    }

    public void push(T elemento) {
        No<T> noAux = new No<>(elemento);

        if (topo == null) {
            topo = noAux;
            tras = noAux;
        } else {
            tras.setProximo(noAux);
            tras = noAux;
        }
        tamanho++;
    }

    public T pop() {
        if (topo != null) {
            T elementoRemovido = topo.getElemento();
            topo = topo.getProximo();
            tamanho--;
            if (topo == null) {
                tras = null;
            }
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
        FilaDinamica<Integer> fila = new FilaDinamica<>();

        fila.push(10);
        fila.push(20);
        fila.push(30);
        fila.push(40);
        fila.pop();
        fila.pop();
        fila.pop();

        System.out.println("Tamanho da fila: " + fila.tamanho());
        System.out.println("A fila está vazia? " + fila.estaVazia());
        fila.imprimir();
    }
}
