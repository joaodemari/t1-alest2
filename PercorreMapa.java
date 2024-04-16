import java.util.HashSet;

public class PercorreMapa {
    public static int act(char[][] matriz, int rowStart, int contOp) {
        HashSet<Character> numbers = new HashSet<>();
        for(char c = '0'; c <= '9'; c++){
            numbers.add(c);
        }

        int readingColumn = 0;
        int readingRow = rowStart;

        char reading = matriz[readingRow][readingColumn];
        Direcao direcao = Direcao.DIREITA;
        String readingNumber = "";
        boolean ultimoFoiNumero = false;
        int sum = 0;
        contOp+=6;

        while (reading != '#') {

            direcao = Direcao.proximaDirecao(direcao, reading);
            contOp++;
            
            switch (direcao) {

                case DIREITA:
                
                    readingColumn++;
                    break;

                case ESQUERDA:
                    readingColumn--;
                    break;

                case CIMA:
                    readingRow--;
                    break;

                case BAIXO:
                    readingRow++;
                    break;

                default:
                    break;
            }
            contOp++;
            reading = matriz[readingRow][readingColumn];
            contOp++;
            if (numbers.contains(reading))
            {
                readingNumber += reading;
                ultimoFoiNumero = true;
                contOp+=2;
            }
            else if(ultimoFoiNumero)
            {
                ultimoFoiNumero = false;
                int number = Integer.parseInt(readingNumber);
                sum += number;
                readingNumber = "";
                contOp+=4;
            }
           
        }
        System.out.println("soma: " + sum);
        System.out.println("contOp: " + contOp);
        return contOp;
    }
}
