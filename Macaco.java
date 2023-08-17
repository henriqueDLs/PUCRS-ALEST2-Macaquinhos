import java.util.ArrayList;

public class Macaco {
    private int numero;
    private int cocos;
    private int macacoPar;
    private int macacoImp;
    private int qtdPar;
    private int qtdImpar;
    private ArrayList<Integer> pedrinhas;

    public Macaco(int numero, int cocos, int pedrinhas, int macacoPar, int macacoImp){
        this.numero = numero;
        this.cocos = cocos;
        this.pedrinhas = new ArrayList<>();
        this.macacoPar = macacoPar;
        this.macacoImp = macacoImp;
        this.qtdPar = 0;
        this.qtdImpar = 0;
    }

    public Macaco(){
        this.pedrinhas = new ArrayList<>();
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getQtdPar() {
        return qtdPar;
    }

    public void setQtdPar() {
        this.qtdPar += 1;
    }

    public void somaQtdPar(int qtd) {
        this.qtdPar = qtdPar + qtd;
    }

    public int getQtdImpar() {
        return qtdImpar;
    }

    public void setQtdImpar() {
        this.qtdImpar += 1;
    }

    public void somaQtdImpar(int qtd) {
        this.qtdImpar = qtdImpar + qtd;
    }

    public void limparCocos(){
        this.cocos = 0;
        this.qtdPar = 0;
        this.qtdImpar = 0;
    }

    public int getCocos() {
        return cocos;
    }

    public void setCocos(int cocos) {
        this.cocos = cocos;
    }

    public ArrayList<Integer> getPedrinhas() {
        return pedrinhas;
    }

    public void setPedrinhas(ArrayList<Integer> pedrinhas) {
        this.pedrinhas = pedrinhas;
    }

    public int getMacacoPar() {
        return macacoPar;
    }

    public void setMacacoPar(int macacoPar) {
        this.macacoPar = macacoPar;
    }

    public int getMacacoImp() {
        return macacoImp;
    }

    public void setMacacoImp(int macacoImp) {
        this.macacoImp = macacoImp;
    }
}
