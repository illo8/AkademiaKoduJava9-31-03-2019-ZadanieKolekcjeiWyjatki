package pl.academy.code;

import pl.academy.code.data.BookRepository;
import pl.academy.code.exceptions.IdiotBookNameException;
import pl.academy.code.exceptions.NotEnoughPagesException;
import pl.academy.code.gui.Menu;
import pl.academy.code.model.Book;


public class Main {
    public static void main(String[] args) {
        Menu.helloMenu();   //mozemy usunac to co powyżej i teraz wywolac utworzona metode helloMenu
        try {
            Book book = new Book ("", 234, 44);
        }catch (IdiotBookNameException | NotEnoughPagesException e){
            System.out.println(e.getMessage());
        }
        /*BookRepository bookRepository = BookRepository.getBookRepositoryInstance();   //tworzymy repozytorium
        bookRepository.addBook(new Book("ABC", 23, 20.00));
        bookRepository.printBooks();
        bookRepository.sortBooksByPages();
        bookRepository.printBooks();
        bookRepository.sortBooksByPrice();
        bookRepository.printBooks();
        bookRepository.sortBooksByTitle();
        bookRepository.printBooks();
        */


       // BookRepository bookRepository2 = BookRepository.getBookRepositoryInstance();
        // bookRepository2.printBooks();
    }
}
