public class ReservedWord {
    protected String reservedWord[][];
    public ReservedWord(){
        reservedWord = new String[5][3];
        for(int i=0;i<5;i++){
            reservedWord[i][1]=Integer.toString(i+1);
        }
        reservedWord[0][0]="DIM";
        reservedWord[1][0]="IF";
        reservedWord[2][0]="DO";
        reservedWord[3][0]="STOP";
        reservedWord[4][0]="END";
    }
}
