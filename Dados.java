import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.Normalizer;
import java.util.ArrayList;

public class Dados {
    private ArrayList<Dados> totalDados;
    private ArrayList<Macaco> totalMacacos;
    private int rodadas;
    private String conteudo;


    public Dados(){
        totalDados = new ArrayList<>();
        totalMacacos = new ArrayList<>();
    }

    public Dados(String conteudo){
        this.conteudo = conteudo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public ArrayList<Dados> getTotalDados() {
        return totalDados;
    }

    public ArrayList<Macaco> getTotalMacacos() {
        return totalMacacos;
    }

    public int getRodadas() {
        return rodadas;
    }

    public boolean carregarDados(String nomeArquivo){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(nomeArquivo),"ISO-8859-1"));
            String linha = "";
            rodadas = Integer.parseInt(br.readLine().split("[->: ]")[1]);
            while((linha = br.readLine()) != null){
                linha = Normalizer.normalize(linha, Normalizer.Form.NFKD);
                linha = linha.replaceAll("[^\\p{ASCII}]", "");
                Dados d1 = new Dados(linha);
                totalDados.add(d1);
                totalMacacos.add(new Macaco());
            }
            br.close();
        }
        catch(IOException e){
            return false;
        }
        return true;
    }

    public void organizarDados(){
        String[] conteudoDados;

        for(int i = 0; i< totalDados.size();i++){
            Dados d = totalDados.get(i);
            Macaco m = totalMacacos.get(i);
            conteudoDados = d.getConteudo().split("[->: ]");
            m.setNumero(Integer.parseInt(conteudoDados[1]));
            m.setMacacoPar(Integer.parseInt(conteudoDados[6]));
            m.setMacacoImp(Integer.parseInt(conteudoDados[11]));
            m.setCocos(Integer.parseInt(conteudoDados[14]));
            ArrayList<Integer> pedrinha = new ArrayList<>();
            for(int j =17;j<conteudoDados.length;j++){
                pedrinha.add(Integer.parseInt(conteudoDados[j]));
                if(Integer.parseInt(conteudoDados[j])%2==0){
                    m.setQtdPar();
                }
                else{
                    m.setQtdImpar();
                }
            }
            m.setPedrinhas(pedrinha);
            m.setCocos(pedrinha.size());
        }
    }
}
