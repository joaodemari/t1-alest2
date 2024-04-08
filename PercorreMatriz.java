import java.util.ArrayList;
import java.util.HashSet;

public class PercorreMatriz {
    public static ArrayList<Integer> act(CharAndNextIndex[][] matriz, int rowStart) {
        ArrayList<Integer> moneys = new ArrayList<>();
        HashSet<Character> numbers = new HashSet<>();
        int sum = 0;
        for(char c = '0'; c <= '9'; c++){
            numbers.add(c);
        }

        numbers.add('#');

            int readingColumn = 0;
            int readingRow = rowStart;
            CharAndNextIndex reading = matriz[readingRow][readingColumn];
            Direcao direcao = Direcao.DIREITA;
            String readingNumber = "";
            boolean NotOneStep = false;
            while (reading.getCharacter() != '#') {
                direcao = Direcao.proximaDirecao(direcao, reading.getCharacter());
                int lastRow = readingRow;
                int lastColumn = readingColumn;
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
                char lastCharacter = reading.getCharacter();
                reading = matriz[readingRow][readingColumn];
                if (numbers.contains(reading.getCharacter())) {
                    NotOneStep = !(NotOneStep && numbers.contains(lastCharacter)) && !readingNumber.equals("");
                    if(NotOneStep || reading.getCharacter() == '#'){
                        int number = Integer.parseInt(readingNumber);
                        sum += number;
                        readingNumber = "";
                    }
                    readingNumber += reading.getCharacter();
                }
            }
        System.out.println(sum);
        return moneys;
    }
}
