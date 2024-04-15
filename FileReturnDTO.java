public class FileReturnDTO {
    private char[][] matriz;
    private int rowStart;
    private int contOp;

    public FileReturnDTO(char[][] matriz, int rowStart, int contOp) {
        this.matriz = matriz;
        this.rowStart = rowStart;
        this.contOp = contOp;
    }

    public char[][] getMatriz() {
        return matriz;
    }

    public int getRowStart() {
        return rowStart;
    }

    public int getContOp() {
        return contOp;
    }
}
