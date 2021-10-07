package Analizador;

public class Tokens {

    private String[] Lexema1;
    private String[] Token1;
    private String SiLexema;
    private int NoToken;
    private int i;
    private int TokenInicia;
    private Lexemas AFD;
    final int Min = 7;
    final int Max = 500;

    public int getI(){
        return i;
    }
    public void setI(int valor){
        i=valor;
    }
    public String[] getLexema1(){
        return Lexema1;
    }
    public void setLexema1(String[] lexema1){
        this.Lexema1 = Lexema1;
    }
    public String[] getToken1(){
        return Token1;
    }
    public void setToken1(String[] Token1){
        this.Token1 = Token1;
    }
    public String getSiLexema(){
        return SiLexema;
    }
    public void setSiLexema(String SiLexema){
        this.SiLexema = SiLexema;
    }
    public int getNoLexema(){
        return NoToken;
    }
    public void setNoLexema(int NoLexema){
        this.NoToken = NoLexema;
    }
    public int getTokenInicia(){
        return TokenInicia;
    }
    public void setTokenInicia(int TokenInicia){
        this.TokenInicia = TokenInicia;
    }
    public Lexemas getAfD(){
        return AFD;
    }

    public Tokens(){
        Lexema1 = new String[Max];
        Token1 = new String[Max];
        AFD = new Lexemas();
        i = 0;
        TokenInicia = 0;
        NoToken = 0;
    }
    public void Inicia(){
        i=0;
        TokenInicia = 0;
        NoToken = 0;
        Lexema1 = new String[Max];
        Token1 = new String[Max];
    }

    public void AnalisisAutomata(String TextoAutomata){
        Boolean Auto;
        int noAuto;
        while (i<TextoAutomata.length()){
            Auto = false;
            noAuto = 0;
            for(;noAuto<Min&&!Auto;){
                if(AFD.Reconoce(TextoAutomata, this, noAuto)){
                    Auto = true;
                }else{
                    noAuto++;
                }
            }
            if (Auto){
                SiLexema = TextoAutomata.substring(TokenInicia, i);
                switch (noAuto){
                    case 0: Token1[NoToken] = "Espacio";
                    break;

                    case 1: Token1[NoToken] = "Varibales";
                    break;

                    case 2: Token1[NoToken] = "OperacionAsignacion";
                    break;

                    case 3: Token1[NoToken] = "OperacionAritmetica";
                    break;

                    case 4: Token1[NoToken] = "Numero";
                    break;

                    case 5: Token1[NoToken] = "Separador";
                    break;

                    case 6: Token1[NoToken] = "TerminaAutomata";
                    break;
                }
                Lexema1[NoToken++] = SiLexema;
            }else {
                i++;
            }
            TokenInicia = i;
        }
    }
}
