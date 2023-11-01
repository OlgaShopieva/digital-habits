
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;

public class Library {
    private List<Book> books;
    private List<Reader> readers;
    public Library() {
        init();
    }
    private void init() {
        books = new ArrayList<>();
        books.add(new Book("Оруэлл", "1984", 2021));
        //и так далее для других книг

        readers = new ArrayList<>();
        readers.add(new Reader("Иванов Иван Иванович", "ivanov.email@test.ru", true));
        //и так далее для других читателей

        readers.get(0).getBooks().add(books.get(1));
        //и так далее для других читателей и взятых книг
    }
    public List<Book> getBooks() {
        return books;
    }
    public List<Reader> getReaders() {
        return readers;
    }

    //1.1 sorted without lambda
    public static List<Book> doWithoutLambda(List<Book> books) {
        books.sort(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getIssueYear() - o2.getIssueYear();
            }
        });
        return books;
    }

    //1.2.sorted with lambda
    Library library = new Library();
    List<Book> list = library.getBooks().stream()
            .sorted(Comparator.comparing(Book::getIssueYear))
            .collect(Collectors.toList());

    //2.1 map() without lambda
    // Требуется создать список рассылки (объекты типа EmailAddress) из адресов всех читателей библиотеки.
    // При этом флаг согласия на рассылку учитывать не будем: библиотека закрывается,
    // так что хотим оповестить всех.
//    List<EmailAddress> addresses = new ArrayList<>();
//    for (Reader reader : library.getReaders()) {
//        addresses.add(new EmailAddress(reader.getEmail()));
//    }
    //2.2 map() with lambda
//    List<EmailAddress> addresses = library.getReaders().stream()
//            .map(Reader::getEmail)
//            .map(EmailAddress::new)
//            .collect(Collectors.toList());

    //3.1 filter() without lambda
//    List<EmailAddress> addresses = new ArrayList<>();
//    for(Reader reader: library.getReaders()){
//        if (reader.getBooks().size()>1 && reader.isSubscriber()){
//            addresses.add(new EmailAddress(reader.getEmail()));
////        }
//    }
    //3.2 filter() with lambda
//    List<EmailAddress> addresses = library.getReaders().stream()
//            .filter(Reader::isSubscriber)
//            .filter(reader -> reader.getBooks().size()>1)
//            .map(Reader::getEmail).map(EmailAddress::new)
//            .collect(Collectors.toList());

    //4.1 flatMap() without lambda
//    Set<Book> result = new LinkedHashSet<>();
//    for(Reader reader: library.getReaders()){
//        result.add(reader.getBooks())
//    }
//    return new ArrayList<>(result);

    //4.2 flatMap() with lambda
//    List<Book> result = library.getReaders().stream()
//            .flatMap(reader -> reader.getBooks().stream())
//            .distinct()
//            .collect(Collectors.toList());

    //5.1 reduce() without lambda
    //Узнать наибольшее число книг, которое сейчас на руках у читателя.
//    int max = 0;
//    for(Reader reader: library.getBooks()){
//        if (reader.getBooks().size() > max){
//            max = reader.getBooks().size();
//        }
//        return max;
//    }
    //5.2 reduce() with lambda
//    Integer reduce = library.getReaders().stream()
//            .map(reader->reader.getBooks().size())
//            .reduce(0, (max, size) -> size > max ? size : max);

    //6.1 anyMatch() without lambda
//    boolean result = false;
//    for(Reader reader: library.getReaders()){
//        for(Book book: reader.getBooks()){
//            if("Оруэлл".equals(book.getAuthor()){
//                result = true;
//                break;
//            }
//        }
//    }
    //6.2 anyMatch() with lambda
//    boolean match = library.getReaders().stream()
//            .flatMap(reader -> reader.getBooks().stream())
//            .anyMatch(book ->"Оруэлл".equals(book.getAuthor()));
    /*
    7.1 collect/Collector.groupingBy/mapping without lambda
    Теперь нужно не просто отправить письма всем, кто согласился на рассылку,
    — будем рассылать разные тексты двум группам:
тем, у кого взято меньше двух книг, просто расскажем о новинках библиотеки;
тем, у кого две книги и больше, напомним о том, что их нужно вернуть в срок.
То есть надо написать метод, который вернёт два списка адресов (типа EmailAddress):
с пометкой OK — если книг не больше двух, или TOO_MUCH — если их две и больше.
 Порядок групп не важен.
     */
//    Map<String, List<EmailAddress>> result = new HashMap<>();
//    for(Reader reader:library.getReaders()){
//        if(reader.isSubscriber()){
//            if(reader.getBooks().size() > 2){
//                if(!result.containsKey("Too mach")){
//                    result.put("Too much", new ArrayList<>());
//                }
//                result.get("Too much").add(new EmailAddress(reader.getEmail()));
//            }
//            else {
//                if(!result.containsKey("OK")){
//                    result.put("OK", new ArrayList<>());
//                }
//                result.get("OK").add(new EmailAddress(reader.getEmail()));
//            }
//        }
//    }
//    return result;
    //7.2 collect/Collector.groupingBy/mapping without lambda
    Map<String, List<EmailAddress>> result = library.getReaders().stream()
            .filter(Reader::isSubscriber)
            .collect(groupingBy(r -> r.getBooks().size() > 2 ? "TOO_MUCH" : "OK",
                    mapping(r-> new EmailAddress(r.getEmail()), Collectors.toList())));
}
