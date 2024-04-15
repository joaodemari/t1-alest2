import java.util.ArrayList;
import java.util.HashSet;

public class PercorreMapa {
    public static int act(CharAndNextIndex[][] matriz, int rowStart, int contOp) {
        HashSet<Character> numbers = new HashSet<>();
        int sum = 0;
        for(char c = '0'; c <= '9'; c++){
            numbers.add(c);
            contOp++;
        }

        numbers.add('#');

            int readingColumn = 0;
            int readingRow = rowStart;
            CharAndNextIndex reading = matriz[readingRow][readingColumn];
            Direcao direcao = Direcao.DIREITA;
            String readingNumber = "";
            boolean NotOneStep = false;
            contOp+=5;
            while (reading.getCharacter() != '#') {
                direcao = Direcao.proximaDirecao(direcao, reading.getCharacter());
                int lastRow = readingRow;
                int lastColumn = readingColumn;
                contOp+=3;
                switch (direcao) {
                    case DIREITA:
                        readingColumn = reading.getIndexHorizontalDireita();
                        NotOneStep = Math.abs(readingColumn - lastColumn) == 1;
                        break;
                    case ESQUERDA:
                        readingColumn = reading.getIndexHorizontalEsquerda();
                        NotOneStep = Math.abs(readingColumn - lastColumn) == 1; 
                        break;
                    case CIMA:
                        readingRow = reading.getIndexVerticalEmCima();
                        NotOneStep = Math.abs(readingRow - lastRow) == 1;
                        break;
                    case BAIXO:
                        readingRow = reading.getIndexVerticalEmBaixo();
                        NotOneStep = Math.abs(readingRow - lastRow) == 1;
                        break;
                    default:
                    break;
                }
                contOp+=2;
                char lastCharacter = reading.getCharacter();
                reading = matriz[readingRow][readingColumn];
                if (numbers.contains(reading.getCharacter())) {
                    NotOneStep = !(NotOneStep && numbers.contains(lastCharacter)) && !readingNumber.equals("");
                    if(NotOneStep || (reading.getCharacter() == '#' && readingNumber != "")){
                        int number = Integer.parseInt(readingNumber);
                        sum += number;
                        readingNumber = "";
                        contOp+=3;
                    }
                    readingNumber += reading.getCharacter();
                    contOp+=2;
                }
            }

        System.out.println("Resultado da soma: " + sum);
        return contOp;
    }
}
