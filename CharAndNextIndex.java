public class CharAndNextIndex {
    private char character = ' ';
    private int IndexHorizontal = -1;
    private int IndexVertical = -1;
    private int IndexVerticalEmBaixo = -1;
    private int IndexVerticalEmCima = -1;
    private int IndexHorizontalDireita = -1;
    private int IndexHorizontalEsquerda = -1;

    public CharAndNextIndex(char character, int indexVerticalEmBaixo, int indexVerticalEmCima, int indexHorizontalDireita, int indexHorizontalEsquerda) {
        this.character = character;
        IndexVerticalEmBaixo = indexVerticalEmBaixo;
        IndexVerticalEmCima = indexVerticalEmCima;
        IndexHorizontalDireita = indexHorizontalDireita;
        IndexHorizontalEsquerda = indexHorizontalEsquerda;
    }

    public CharAndNextIndex() {
    }

    public int getIndexVerticalEmBaixo() {
        return IndexVerticalEmBaixo;
    }

    public void setIndexVerticalEmBaixo(int indexVerticalEmBaixo) {
        IndexVerticalEmBaixo = indexVerticalEmBaixo;
    }

    public int getIndexVerticalEmCima() {
        return IndexVerticalEmCima;
    }

    public void setIndexVerticalEmCima(int indexVerticalEmCima) {
        IndexVerticalEmCima = indexVerticalEmCima;
    }

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    public int getIndexHorizontalDireita() {
        return IndexHorizontalDireita;
    }

    public void setIndexHorizontalDireita(int indexHorizontalDireita) {
        IndexHorizontalDireita = indexHorizontalDireita;
    }

    public int getIndexHorizontalEsquerda() {
        return IndexHorizontalEsquerda;
    }

    public void setIndexHorizontalEsquerda(int indexHorizontalEsquerda) {
        IndexHorizontalEsquerda = indexHorizontalEsquerda;
    }

    public int getIndexVertical() {
        return IndexVertical;
    }

    public void setIndexVertical(int indexVertical) {
        IndexVertical = indexVertical;
    }

    public int getIndexHorizontal() {
        return IndexHorizontal;
    }

    public void setIndexHorizontal(int indexHorizontal) {
        IndexHorizontal = indexHorizontal;
    }
}
