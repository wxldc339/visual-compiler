public class WordAnalyse {
    protected int code,searchPtr=0;
    private String value;
    private String strToken="";//字符数组，存放构成单词字符的字符串；
    public char ch;//字符变量，存放最新读进的源程序字符串；
    protected char[] str;//存放源程序字符串；


    public void getString(String str1){
          str = str1.toCharArray();
    }

    public void getChar(){
        ch=str[searchPtr];
        searchPtr++;
    }
    public void getBC(){
        while(Character.isSpace(ch)){
            getChar();
        }
    }

    public void concat(){
        strToken += ch;
    }
    public boolean isLetter(){
        return Character.isLowerCase(ch)||Character.isUpperCase(ch);
    }
    public boolean isDigit(){
        return Character.isDigit(ch);
    }

    public void retract(){
        searchPtr--;
        ch='\0';
    }

    public String reserve(){
        ReservedWord rw = new ReservedWord();
        for(int i=0;i<5;i++){
            if(strToken.equals(rw.reservedWord[i][0])){
                return rw.reservedWord[i][1];
            }
        }
        return "0";
    }



    public BinaryGroup wordAnalyse(){
        getChar();getBC();
        if (isLetter()){
            while(isLetter()||isDigit()){
                concat();getChar();
            }
            retract();
            code=Integer.valueOf(reserve());
            if(code==0){
                value=strToken;
                strToken="";
                return new BinaryGroup("$ID",value);
            }
        } else if (isDigit()) {
            while(isDigit()){
                concat();
                getChar();
            }
            retract();
            value=strToken;
            strToken="";
            return new BinaryGroup("$INT",value);
        } else if (ch=='*') {
            getChar();
            if(ch=='*') return new BinaryGroup("$power","-");
            retract();
            return new BinaryGroup("$STAR","-");
        } else if (ch=='=') return new BinaryGroup("$ASSIGN","-");
        else if (ch=='+') return new BinaryGroup("$PLUS","-");
        else if (ch==';') return new BinaryGroup("$SEMICOLON","-");
        else if (ch=='(') return new BinaryGroup("$LPAR","-");
        else if (ch==')') return new BinaryGroup("$RPAR","-");
        else if (ch=='{') return new BinaryGroup("$LBRACE","-");
        else if (ch=='}') return new BinaryGroup("$RBRACE","-");
        return null;
    }

}
