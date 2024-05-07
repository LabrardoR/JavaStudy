package book;

/*
书架
 */
public class BookList {
    private Book[] books;
    private int usedSize;//记录当前书架存放书的数量
    private static final int DEFAULT_CAPACITY = 10;

    public BookList(){
        this.books = new Book[DEFAULT_CAPACITY];
        this.books[0] = new Book("三国演义","罗贯中",10,"小说");
        this.books[1] = new Book("西游记","吴承恩",9,"小说");
        this.books[2] = new Book("红楼梦","曹雪芹",19,"小说");

        this.usedSize = 3;
    }

    public Book[] getBooks() {
        return books;
    }
//    public void setBooks(int pos,Book book) {
//        this.books[pos] = book;
//    }
    public Book getBook(int pos){
        return books[pos];
    }
    public void setBook(int pos, Book book){
        this.books[pos] = book;
    }

    public int getUsedSize() {
        return usedSize;
    }

    public void setUsedSize(int usedSize) {
        this.usedSize = usedSize;
    }


}
