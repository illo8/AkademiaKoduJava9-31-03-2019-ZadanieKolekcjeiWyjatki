package pl.academy.code.exceptions;

public class IdiotBookNameException extends Exception {   //dziedziczenie - nie musimy w tym nic implementowac
    @Override
    public String getMessage(){
        return "Tytul ksiazki jest glupi !!";
    }
}
