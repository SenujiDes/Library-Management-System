import java.time.LocalDate;

public class Lend {
    private Member lendedMember;
    private Book lendedBook;
    private LocalDate dueDate;
    private boolean isLending;

    //constructor
    Lend(Member _lendMember, Book _lendedBook,LocalDate _duDate){
        lendedMember=_lendMember;
        lendedBook=_lendedBook;
        dueDate=_duDate;
        isLending= false;
    }

    //setters
    public void setIsLending(boolean _isLending){
        isLending=_isLending;
    }

   //getters
   public Member getLendedMember(){
    return lendedMember;
   }

   public Book getLendedBook(){
    return lendedBook;
   }

   public LocalDate getDueDate(){
    return dueDate;
   }

   public boolean getIsLending(){
    return isLending;
   }

   public boolean getLendDetails(){
        lendedMember.registered_members(); //calling registered_members method in Member class
        lendedBook.book_details(); //calling book_details method in Book class
        return true;

   }
}
