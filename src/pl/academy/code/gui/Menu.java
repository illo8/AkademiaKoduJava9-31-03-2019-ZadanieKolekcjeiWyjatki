package pl.academy.code.gui;

import pl.academy.code.data.BookRepository;
import pl.academy.code.exceptions.IdiotBookNameException;
import pl.academy.code.exceptions.NotEnoughPagesException;
import pl.academy.code.model.Book;

import java.util.Scanner;

public class Menu {


    public static void helloMenu() {
        do{
        System.out.println("1.Dodaj ksiazke");
        System.out.println("2. Wyswietl ksiazki");
        System.out.println("3. Sortuj po nazwie");
        System.out.println("4. Sortuj po cenie");
        System.out.println("5. Sortuj po ilosci stron");
        System.out.println("6. Koniec");


            Scanner scanner = new Scanner(System.in);
            int choose = Integer.parseInt(scanner.nextLine());   //robimy parsowanie

            // lepiej dac teraz switch bo przyrownamy zmienna do danej wartosci:

            switch (choose) {
                case 1:
                    Menu.loadBook();    //moze byc tez 'loadBook()'
                    break;
                case 2:
                    //muszę zrobic repository:
                    BookRepository.getBookRepositoryInstance().printBooks();
                    break;
                case 3:
                    BookRepository.getBookRepositoryInstance().sortBooksByTitle();
                    break;
                case 4:
                    BookRepository.getBookRepositoryInstance().sortBooksByPrice();
                    break;
                case 5:
                    BookRepository.getBookRepositoryInstance().sortBooksByPages();
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    break;

            }
        } while (true);
    }

        public static void loadBook(){
            System.out.println("Podaj tytuł:");

            Scanner scanner = new Scanner(System.in);
            String title = scanner.nextLine();

            System.out.println("Podaj liczbe stron:");
            int pages = -1;                   //wczesniej tutaj;int pages = Integer.parseInt(scanner.nextLine()); jest ponizej to wlasnie zakomentowane; to co nizej to juz doddany kod
                                                //wczesniej bylo 0, teraz -1 czyli blad bo wartosc dla liczby stron nie moze byc -1
            boolean flag = true;
            while (flag) {   //? działaj gdy pages bedzie -1   wczesniej bylo (pages == -1)
                try {                                //probujemy kod
                    pages = Integer.parseInt(scanner.nextLine());
                    flag = false;
                    // System.out.println("Cos po bledzie !!");

                } catch (NumberFormatException e) {                   //lapie wyjatek i w zaleznosci co wyskoczy to na to jest odpowiedz
                    e.printStackTrace();
                    System.out.println("Podaj liczbe stron (nieprawidlowa ilosc):");




                //pages = 500;
           /* }catch (NullPointerException e) {                   // ta literka e to nowy obiekt ktory sie utworzyl i zostal nam zwrocony
                System.out.println("Zepsulo sie inaczej !!");
                e.printStackTrace();
                */
                //pages = 500;
           // }finally {   dajemy jesli pod catchami nie bedzie tego pages = 500; ale ten bloczek zawsze sie odpala, nawet jesli nie wchodzimy w catch bo wszystko jest ok i nie ma wyjatku
           //     pages = 500;

          /*  }finally {
                if (pages < 1) {
                    pages = 500;
           */
                }
            }

            /*
            albo cath mozna inaczej:
             }catch (NumberFormatException | NullPointerException e) {  jedno e bo to nazwa zmiennej
                System.out.println("Zepsulo sie !!");
                e.printStackTrace();
            }
             */

            //Scanner scanner2 = new Scanner(System.in);
           // int pages = Integer.parseInt(scanner.nextLine());

            System.out.println("Podaj cene:");

            //Scanner scanner3 = new Scanner(System.in);
            double price = Double.parseDouble(scanner.nextLine());

            try {
                BookRepository.getBookRepositoryInstance()
                        .addBook(new Book(title, pages, price));
            } catch (IdiotBookNameException | NotEnoughPagesException e){
                System.out.println(e.getMessage());
            }




            //albo zamiast dwoch ost. linijek: BookRepository.getBookRepositoryInstance().addBook(new Book(title, pages, price ));
        }

    }

