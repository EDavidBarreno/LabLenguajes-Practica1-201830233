package Analizador;

import java.util.Calendar;

public class Lexemas {

    String Texto1;
    int Act;

    private char Siguiente(int i) {
        if (i == Texto1.length()) {
            return ' ';
        } else {
            return Texto1.charAt(i);
        }
    }

    public Boolean Reconoce(String TextoAutomata, Tokens analisisLexico, int noAuto){
        char c;
        Texto1 = TextoAutomata;
        String lenguaje;
        switch (noAuto){
            case 0 : Act = 0;
            break;
            case 1 : Act = 3;
            break;
            case 2 : Act = 6;
            break;
            case 3 : Act = 9;
            break;
            case 4 : Act = 11;
            break;
            case 5 : Act = 16;
            break;
        }

        while(analisisLexico.getI() <=Texto1.length()){
            switch (Act){

                case 0 : c=Siguiente(analisisLexico.getI());
                analisisLexico.setI(analisisLexico.getI()+1);
                if ((lenguaje=" \n\r\t").indexOf(c)>=0){
                    Act=1;
                }else {
                    analisisLexico.setI(analisisLexico.getTokenInicia());
                    return false;
                }

                break;

                case 1 : c=Siguiente(analisisLexico.getI());
                analisisLexico.setI(analisisLexico.getI()+1);
                if ((lenguaje=" \n\r\t").indexOf(c)>=0){
                    Act = 1;
                }else
                    if ((lenguaje = ".,;:+-*/%(){}[]ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789").indexOf(c) >= 0) {
                        Act = 2;
                    }else{
                        analisisLexico.setI(analisisLexico.getTokenInicia());
                        return false;
                    }

                break;


                case 2: analisisLexico.setI(analisisLexico.getI()-1);
                return true;
                case 3: c=Siguiente(analisisLexico.getI());
                analisisLexico.setI(analisisLexico.getI()+1);
                if((lenguaje="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz").indexOf(c)>=0){
                    Act = 4;
                }else
                    if((lenguaje = "_").indexOf(c)>=0){
                        Act = 4;
                    } else {
                        analisisLexico.setI(analisisLexico.getTokenInicia());
                        return false;
                    }

                    break;

                case 4: c=Siguiente(analisisLexico.getI());
                analisisLexico.setI(analisisLexico.getI()+1);
                if((lenguaje="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz").indexOf(c)>=0){
                    Act = 4;
                }else
                    if ((lenguaje="_").indexOf(c)>=0){
                        Act = 4;
                    }else
                        if((lenguaje="0123456789").indexOf(c)>=0){
                            Act=4;
                        }else
                            if ((lenguaje=".,;:+-*/%(){}[]").indexOf(c)>=0){
                                Act =5;
                            }else{
                                analisisLexico.setI(analisisLexico.getTokenInicia());
                                return false;
                            }

                            break;

                case 5: analisisLexico.setI(analisisLexico.getI()-1);
                return true;
                case 6: c=Siguiente(analisisLexico.getI());
                analisisLexico.setI(analisisLexico.getI()+1);
                if((lenguaje="=").indexOf(c)>=0){
                    Act = 7;
                }else
                    if((lenguaje="+").indexOf(c)>=0){
                        Act = 8;
                    }else
                    if((lenguaje="-").indexOf(c)>=0){
                        Act = 8;
                    }else
                    if((lenguaje="*").indexOf(c)>=0){
                        Act = 8;
                    }else
                    if((lenguaje="/").indexOf(c)>=0){
                        Act = 8;
                    }else {
                        analisisLexico.setI(analisisLexico.getTokenInicia());
                        return false;
                    }

                    break;

                case 7: return true;
                case 8 : c=Siguiente(analisisLexico.getI());
                analisisLexico.setI(analisisLexico.getI()+1);
                if ((lenguaje="=").indexOf(c)>=0){
                    Act = 7;
                } else {
                    analisisLexico.setI(analisisLexico.getTokenInicia());
                    return false;
                }
                break;

                case  9 : c=Siguiente(analisisLexico.getI());
                analisisLexico.setI(analisisLexico.getI()+1);
                if ((lenguaje="+").indexOf(c)>=0){
                    Act = 10;
                }else
                if ((lenguaje="-").indexOf(c)>=0){
                    Act = 10;
                }else
                if ((lenguaje="*").indexOf(c)>=0){
                    Act = 10;
                }else
                if ((lenguaje="/").indexOf(c)>=0){
                    Act = 10;
                }else {
                    analisisLexico.setI(analisisLexico.getTokenInicia());
                    return false;
                }
                break;

                case 10: return true;

                case 11: c=Siguiente(analisisLexico.getI());
                analisisLexico.setI(analisisLexico.getI()+1);
                if ((lenguaje="0123456789").indexOf(c)>=0){
                    Act = 12;
                }else {
                    analisisLexico.setI(analisisLexico.getTokenInicia());
                    return false;
                }
                break;

                case 12 : c=Siguiente(analisisLexico.getI());
                analisisLexico.setI(analisisLexico.getI()+1);
                if ((lenguaje="0123456789").indexOf(c)>=0){
                    Act = 12;
                }else
                    if((lenguaje=".,;:+-*/%(){}[]ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789").indexOf(c)>=0){
                        Act =13;
                    }else
                        if ((lenguaje=".").indexOf(c)>=0){
                         Act = 14;
                        }else {
                            analisisLexico.setI(analisisLexico.getTokenInicia());
                            return false;
                        }
                        break;


                case 13: analisisLexico.setI(analisisLexico.getI()-1);
                return true;

                case 14: c=Siguiente(analisisLexico.getI());
                analisisLexico.setI(analisisLexico.getI()+1);
                if ((lenguaje="0123456789").indexOf(c)>=0){
                    Act = 15;
                }else {
                    analisisLexico.setI(analisisLexico.getTokenInicia());
                    return false;
                }
                break;

                case 15: c=Siguiente(analisisLexico.getI());
                analisisLexico.setI(analisisLexico.getI()+1);
                if ((lenguaje="0123456789").indexOf(c)>=0){
                    Act = 15;
                } else
                    if((lenguaje=".,;:+-*/%(){}[]ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789").indexOf(c)>=0){
                        Act = 13;
                    }else
                        if ((lenguaje=".").indexOf(c)>=0){
                            Act = 13;
                        }else {
                            analisisLexico.setI(analisisLexico.getTokenInicia());
                            return false;
                        }
                        break;

                case 16:c=Siguiente(analisisLexico.getI());
                analisisLexico.setI(analisisLexico.getI()+1);
                if ((lenguaje="(").indexOf(c)>=0){
                    Act = 17;
                }else
                    if((lenguaje=")").indexOf(c)>=0){
                        Act = 17;
                    }else {
                        analisisLexico.setI(analisisLexico.getTokenInicia());
                        return false;
                    }
                    break;

                case 17: return true;

                case 18: c=Siguiente(analisisLexico.getI());
                analisisLexico.setI(analisisLexico.getI()+1);
                if ((lenguaje=";").indexOf(c)>=0){
                    Act = 19;
                }else {
                    analisisLexico.setI(analisisLexico.getTokenInicia());
                    return false;
                }
                break;

                case 19: return true;
            }
        }
        switch (Act){
            case 2:
            case 5:
            case 13:
                analisisLexico.setI(analisisLexico.getI()-1);
                return true;
        }
        return false;
    }
}


