import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BinaryGroup[] bg = new BinaryGroup[100];
        int bgptr=0;

        Scanner scanner =  new Scanner(System.in);
        String str = scanner.nextLine();

        WordAnalyse wa = new WordAnalyse();
        wa.getString(str);
        while(wa.searchPtr<wa.str.length) {
            bg[bgptr]=wa.wordAnalyse();
            System.out.println(bg[bgptr]);
            bgptr++;
        }
    }
}