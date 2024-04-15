public class FileReturnDTO {
    private CharAndNextIndex[][] matriz;
    private int rowStart;
    private int contOp;

    public FileReturnDTO(CharAndNextIndex[][] matriz, int rowStart, int contOp) {
        this.matriz = matriz;
        this.rowStart = rowStart;
    }

    public CharAndNextIndex[][] getMatriz() {
        return matriz;
    }

    public int getRowStart() {
        return rowStart;
    }

    public int getContOp() {
        return contOp;
    }
}
