import java.util.ArrayList;

public class Main{
    public static void main(String[] args) {

        ArrayList<String> arquivos = new ArrayList<>();
        arquivos.add("casoE10.txt");
        arquivos.add("casoE50.txt");
        arquivos.add("casoE100.txt");
        arquivos.add("casoE200.txt");
        arquivos.add("casoE500.txt");
        arquivos.add("casoE750.txt");
        arquivos.add("casoE1000.txt");
        arquivos.add("casoE1500.txt");
        arquivos.add("casoE2000.txt");

        for (int i = 0; i < arquivos.size(); i++) {
            int contOp = 0;
            String nome = arquivos.get(i);
            FileReturnDTO read = LerArquivoTexto.toMatrix(nome, contOp);
            int finalContOp = PercorreMapa.act(read.getMatriz(), read.getRowStart(), contOp);
            System.out.println("Arquivo: " + nome + " - Operações: " + finalContOp);
        }
       
    }
}