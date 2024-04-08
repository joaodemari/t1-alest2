import java.util.HashMap;

public enum Direcao {
    DIREITA, ESQUERDA, CIMA, BAIXO;

    public static Direcao proximaDirecao(Direcao direcaoAtual, char caractere) {
        HashMap<Character, Direcao> map = new HashMap<>();
        map.put('/', switch (direcaoAtual) {
            case DIREITA -> CIMA;
            case ESQUERDA -> BAIXO;
            case CIMA -> DIREITA;
            case BAIXO -> ESQUERDA;
        });
        map.put('\\', switch (direcaoAtual) {
            case DIREITA -> BAIXO;
            case ESQUERDA -> CIMA;
            case CIMA -> ESQUERDA;
            case BAIXO -> DIREITA;
        });

        return map.getOrDefault(caractere, direcaoAtual); 
    }
}
