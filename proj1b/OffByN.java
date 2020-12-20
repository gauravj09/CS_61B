public class OffByN extends Object implements CharacterComparator {
    private int differenceOfN;

    public OffByN(int n) {
        differenceOfN = n;
    }

    @Override
    public boolean equalChars(char x, char y) {
        return Math.abs(x - y) == differenceOfN;
    }
}
