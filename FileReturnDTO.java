public class FileReturnDTO {
    private CharAndNextIndex[][] matriz;
    private int rowStart;

    public FileReturnDTO(CharAndNextIndex[][] matriz, int rowStart) {
        this.matriz = matriz;
        this.rowStart = rowStart;
    }

    public CharAndNextIndex[][] getMatriz() {
        return matriz;
    }

    public int getRowStart() {
        return rowStart;
    }
}
