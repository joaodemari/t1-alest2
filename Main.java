import java.util.Date;

public class Main{
    public static void main(String[] args) {
        for(int i = 0; i < 10 ; i++){
        long init = new Date().getTime(); 
        FileReturnDTO read = LerArquivoTexto.toMatrix("casoE50.txt");
        PercorreMatriz.act(read.getMatriz(), read.getRowStart());
        long end = new Date().getTime();
        System.out.println("tempo da iteração "+ i + ":" + (end - init));
        }
    }
}