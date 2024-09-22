public class Book {
    private String bookName;
    private String author;
    private int bookRegNum;
    private boolean isAvailable;

     
    //constructor
    Book(String _bookName, String _author, int _BookregNum){
        bookRegNum=_BookregNum;
        bookName=_bookName;
        author=_author;
        isAvailable=true;
    }

    //setters

    public void setBookName(String _bookName){
        bookName=_bookName;
    }

    public void setAuthor(String _author){
        author= _author;
    }

    public void setBookRegNum(int _BookregNum){
        bookRegNum=_BookregNum;
    }

    public void setIsAvailable(boolean _isAvailable){
        isAvailable=_isAvailable;
    }

    //getters

    public String getBookName(){
        return bookName;
    }

    public String getAuthor(){
        return author;
    }

    public int getBookRegNum(){
        return bookRegNum;
    }

    public boolean getIsAvailable(){
        return isAvailable;
    }

   

    public void book_details(){
        System.out.println("Book Registered Number:"+ bookRegNum);
        System.out.println("Book Name             : "+ bookName);
        System.out.println("Book author           : "+ author);
        //System.out.println("Available             : " + isAvailable);

    }

   


    
}
