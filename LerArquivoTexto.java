import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LerArquivoTexto {
    public static FileReturnDTO toMatrix(String nome, int contOp) {
        CharAndNextIndex[][] matriz = new CharAndNextIndex[1][1];
        
        int rowStart = 0;
        try {
            FileReader arquivoLeitura = new FileReader(nome);
            BufferedReader bufferLeitura = new BufferedReader(arquivoLeitura);

            String linha = bufferLeitura.readLine();
            String[] tamanhos = linha.split(" ");
            int colunas = Integer.parseInt(tamanhos[0]);
            int linhas = Integer.parseInt(tamanhos[1]);
            matriz = new CharAndNextIndex[colunas][linhas];
            CharAndNextIndex[] waiting = new CharAndNextIndex[colunas];
            for (int i = 0; i < linhas; i++) {
                linha = bufferLeitura.readLine();
                CharAndNextIndex UltimoCaractere = null;
                contOp+=2;
                if (linha.charAt(0) == '-') {
                    rowStart = i;

                    CharAndNextIndex charAndNextIndex = new CharAndNextIndex();

                    charAndNextIndex.setCharacter('-');

                    charAndNextIndex.setIndexHorizontal(0);

                    matriz[i][0] = charAndNextIndex;
                    UltimoCaractere = charAndNextIndex;
                    contOp+=4;


                }

                for (int j = 0; j < colunas; j++) {
                    char caractere = linha.charAt(j);
                    if(caractere == ' '){
                        contOp++;
                        continue;
                    }

                    if(caractere == '-' || caractere == '|'){
                        contOp++;
                        continue;
                    }

                    CharAndNextIndex charAndNextIndex = new CharAndNextIndex();

                    charAndNextIndex.setIndexVertical(i);
                    charAndNextIndex.setIndexHorizontal(j);
                    charAndNextIndex.setCharacter(caractere);

                    matriz[i][j] = charAndNextIndex;
                    contOp+=3;

                    if(UltimoCaractere != null){
                        charAndNextIndex.setIndexHorizontalEsquerda(UltimoCaractere.getIndexHorizontal());
                        UltimoCaractere.setIndexHorizontalDireita(j);
                        contOp+=2;
                    }
                    
                    if(waiting[j] != null){
                        charAndNextIndex.setIndexVerticalEmCima(waiting[j].getIndexVertical());
                        waiting[j].setIndexVerticalEmBaixo(i);
                        contOp+=2;
                    }

                    waiting[j] = charAndNextIndex;
                    UltimoCaractere = charAndNextIndex;
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
