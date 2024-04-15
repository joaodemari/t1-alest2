import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LerArquivoTexto {
    public static FileReturnDTO toMatrix(String nome, int contOp) {
        char[][] matriz = new char[1][1];
        
        int rowStart = 0;
        try {
            FileReader arquivoLeitura = new FileReader(nome);
            BufferedReader bufferLeitura = new BufferedReader(arquivoLeitura);

            String linha = bufferLeitura.readLine();
            String[] tamanhos = linha.split(" ");
            int colunas = Integer.parseInt(tamanhos[0]);
            int linhas = Integer.parseInt(tamanhos[1]);
            matriz = new char[colunas][linhas];
            for (int i = 0; i < linhas; i++) {
                linha = bufferLeitura.readLine();
                contOp++;
                if (linha.charAt(0) == '-') {
                    rowStart = i;
                    contOp++;
                }

                for (int j = 0; j < colunas; j++) {
                    
                    char caractere = linha.charAt(j);
                    matriz[i][j] = caractere;
                    contOp+=2;
                }
            } 
            
            bufferLeitura.close();
            arquivoLeitura.close();
            
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        return new FileReturnDTO(matriz, rowStart, contOp);
    }
}
