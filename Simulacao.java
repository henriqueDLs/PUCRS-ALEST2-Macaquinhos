import java.util.*;

public class Simulacao {
    private int rodadas;
    private Dados d1 = new Dados();
    private Scanner entrada = new Scanner(System.in);

    public Simulacao(){}

    public void executa() {
        int opcao=0;
        do {
            menu();
            try{
                opcao = entrada.nextInt();
            }
            catch (InputMismatchException e){
                System.out.println("Valor invalido, diferente tipo de dado esperado!");
                return;
            }
            entrada.nextLine();
            switch (opcao) {
                case 0:
                    break;
                case 1:
                    carregarDados();
                    break;
                case 2:
                    simular();
                    opcao = 0;
                    break;
                default:
                    System.out.println("Opcao invalida.");
                    break;
            }
        }
        while (opcao != 0);
    }

    private void menu() {
        System.out.println("=======================");
        System.out.println("Opcoes:");
        System.out.println("[0] Sair do sistema");
        System.out.println("[1] Carregar dados");
        System.out.println("[2] Iniciar a simulacao");
    }

    private void carregarDados(){
        System.out.println("Digite o nome do arquivo (Sem o tipo): ");
        String nome = "" + entrada.nextLine() + ".txt";
        d1.carregarDados(nome);
    }

    private void simular(){
        d1.organizarDados();
        rodadas = d1.getRodadas();
        Macaco ma;
        ArrayList<Macaco> totalMacacos = d1.getTotalMacacos();
        Map<Integer, Macaco> mapMacacos = new HashMap<>();
        for (Macaco m : totalMacacos) {
            mapMacacos.put(m.getNumero(), m);
        }
        for(int i=0; i<rodadas;i++){
            for (Macaco m : totalMacacos) {
                ma = mapMacacos.get(m.getMacacoPar());
                ma.somaQtdPar(m.getQtdPar());
                ma = mapMacacos.get(m.getMacacoImp());
                ma.somaQtdImpar(m.getQtdImpar());
                m.limparCocos();
            }
        }
        int maiorValor = Integer.MIN_VALUE;
        Macaco maior = null;
        for(Macaco m : totalMacacos){
            int valorAtual = m.getQtdPar()+m.getQtdImpar();
            m.setCocos(valorAtual);
            if(valorAtual>maiorValor){
                maiorValor = valorAtual;
                maior = m;
            }
        }
        System.out.printf("O macaco vencedor foi o numero %d com %d cocos",maior.getNumero(),maior.getCocos());
        System.out.println();
    }
}
