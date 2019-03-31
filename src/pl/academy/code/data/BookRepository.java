package pl.academy.code.data;
    //?
import pl.academy.code.exceptions.IdiotBookNameException;
import pl.academy.code.exceptions.NotEnoughPagesException;
import pl.academy.code.model.Book;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class BookRepository {
    private List<Book> bookRepository = new LinkedList<>();
    private static BookRepository repositoryInstance = null;

    private BookRepository() {
        try {
            this.bookRepository.add(new Book("PanTadeusz", 400, 40));  //lepszy sposób (szybciej) z 1 wywołaniem stosu
            this.addBook(new Book("W pustyni i w puszczy", 350, 37.99));   //inny sposob, 2 razy wywolanie stosu takie samo dzialanie
            this.bookRepository.add(new Book("Thinking in Java", 1300, 99.99));
            this.bookRepository.add(new Book("Java w 21 dni", 250, 31.90));
            this.bookRepository.add(new Book("Ogniem i mieczem", 400, 37.90));
        } catch (IdiotBookNameException | NotEnoughPagesException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addBook(Book book) {
        this.bookRepository.add(book);             //dodawanie książek
    }

    public void printBooks(){
        System.out.println(this.bookRepository);
    }

    public static BookRepository getBookRepositoryInstance() {      //wzorzec projektowy singleton
        if (BookRepository.repositoryInstance == null) {
            BookRepository.repositoryInstance = new BookRepository();
        }
        return BookRepository.repositoryInstance;
    }

    public void sortBooks(Comparator c){
        this.bookRepository.sort(c);
    }

    public void sortBooksByPages() {
        Comparator c = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (!(o1 instanceof Book)){
                    return -1;
                }
                if (!(o1 instanceof Book)) {
                    return -1;
                }
                return ((Book)o1).getPages() - ((Book)o2).getPages();
            }
        };    //średnik bo każda linijka kończy sie linijka a od momentu 'Comperator c = ...' mamy nową całą linijke

        this.bookRepository.sort(c);
    }



    public void sortBooksByPrice() {
        Comparator c = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (!(o1 instanceof Book)){
                    return -1;
                }
                if (!(o1 instanceof Book)) {
                    return -1;
                }
                return (int) ((((Book)o1).getPrice() - ((Book)o2).getPrice()) *100);   //komperator; nie chcemy doubla tylko int wiec rzutujemy na int
                                                                                        //dodatkowo mnozymy razy 100 bo tyle groszy ma zlotowka
            }
        };    //średnik bo każda linijka kończy sie linijka a od momentu 'Comperator c = ...' mamy nową całą linijke

        this.bookRepository.sort(c);
    }






    public void sortBooksByTitle() {
        Comparator c = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {   //klasa anonimowa
                if (!(o1 instanceof Book)){
                    return -1;
                }
                if (!(o1 instanceof Book)) {
                    return -1;
                }
                return  ((Book)o1).getTitle().compareTo( ((Book)o2).getTitle() );      //komperator

            }
        };    //średnik bo każda linijka kończy sie linijka a od momentu 'Comperator c = ...' mamy nową całą linijke

        this.bookRepository.sort(c);    //sortuj przy uzyciu tego komperatora
    }







}
