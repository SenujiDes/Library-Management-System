import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    private int regNumber = 10012;
    private int bookRegNum = 1000;
   
    //ArrayLists
    private ArrayList<Book> bookList = new ArrayList<>();
    private ArrayList<Member> memberList = new ArrayList<>();
    private ArrayList<Lend> lendDetails = new ArrayList<>();

    Scanner input = new Scanner(System.in);

     //book
    public int BookSearch(int BookNumber) {
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getBookRegNum() == BookNumber) {
                return i; // returns the index
            }
        }
        return -1;
    }

    public void addBook() {
        System.out.print("Enter the book name: ");
        String bookName = input.nextLine();
        System.out.print("Enter the author   : ");
        String author = input.nextLine();
        int BookNum = bookRegNum++;
        Book newBook = new Book(bookName, author, BookNum);
        bookList.add(newBook);
        System.out.println("The book regNum is  :" + BookNum);
        System.out.println("The book is added successfully");
        System.out.println();
    }

    public void removeBook() {
        System.out.print("Book number to be removed:");
        int BoookNum = input.nextInt();
        int remove_index = BookSearch(BoookNum);
        if (remove_index != -1) {
            bookList.remove(remove_index);
            System.out.println("Book has been removed successfully");
            System.out.println();
        } else {
            System.out.println("Sorry, The book number you have provided is incorrect");
            System.out.println();
        }
    }

    public void showBooks(){
        System.out.println();
        System.out.println("Display Books");
        System.out.println();

        if(bookList.isEmpty()){
            System.out.println("No book available");
            System.out.println();
            return;
        }
        for(int j=0; j< bookList.size(); j++){
            if(bookList.get(j).getIsAvailable()){
                bookList.get(j).book_details();
                System.out.println("The book availability   : Available");
                System.out.println("______________________________________________");
                System.out.println();
            }
            else{
                bookList.get(j).book_details();
                System.out.println("The book availability   : Not Available");
                System.out.println("______________________________________________");
                System.out.println();
            }
           
        }
    }

    public void DisplayRelaventBook(){
        System.out.print("Enter the registered number of the book:");
        int regNum= input.nextInt();
        System.out.println();
        
        int index_book = BookSearch(regNum);
        if(index_book != -1){
            //bookList.get(index_book).book_details();
            if(bookList.get(index_book).getIsAvailable()){
                bookList.get(index_book).book_details();
                System.out.println("The book availability: Available");
                System.out.println("______________________________________________");
                System.out.println();
            }
            else{
                bookList.get(index_book).book_details();
                System.out.println("The book availability: Not Available");
                System.out.println("______________________________________________");
                System.out.println();
            }
        }
        else{
            System.out.println("Sorry, The book number you have provided is incorrect");
        }
    }

    //members
    public int MemeberSearch(int memberIdNum){
        for(int j=0; j< memberList.size(); j++){
            if(memberList.get(j).getMemberID() == memberIdNum){
                return j;
            }
        }
        return -1;
    }

    public void addMember(){
        System.out.print("Enter the member name: ");
        String memberName = input.nextLine();
        int memberRegNum = regNumber++;
        Member newMember = new Member(memberName, memberRegNum);
        memberList.add(newMember);
        System.out.println("Member regstration number:" + memberRegNum);
        System.out.println("Registration was successful");
        System.out.println();
    }

    public void removeMember(){
        System.out.print("Enter member's registration number:");
        int memberId= input.nextInt();
        int remove_id= MemeberSearch(memberId);
        if(remove_id != -1){
            memberList.remove(remove_id);
            System.out.println("The member is successfully removed");
            System.out.println();
        }
        else{
            System.out.println("Sorry,The member id provided is incorrect");
            System.out.println();
        }
    }

    public void showMembers(){
        System.out.println("Display Members");
        System.out.println();
       
        if(memberList.isEmpty()){
            System.out.println("No member available");
            System.out.println();
            return;
        }
        for(int j=0; j<memberList.size(); j++){
           memberList.get(j).registered_members();
        }
    }

    public void DisplayRelaventMember(){
        System.out.print("Enter the member ID: ");
        int member_id= input.nextInt();
        System.out.println();
        
        int index_member = MemeberSearch(member_id);
        if(index_member != -1){
           memberList.get(index_member).registered_members();
        }
        else{
            System.out.println("Sorry, The book number you have provided is incorrect");
        }
    }

    //Leding Details
    public boolean LendBook(){
        System.out.print("Enter the book registered number: ");
        int bookNum = input.nextInt();
        // System.out.println();

        int indexNum = BookSearch(bookNum);
        if(indexNum != -1){
            if(bookList.get(indexNum).getIsAvailable() == true){
                System.out.print("Enter the member ID: ");
                int memberID = input.nextInt();
                int MemberNum =MemeberSearch(memberID);
                if(MemberNum != -1){
                    Lend borrowDetails = new Lend(memberList.get(MemberNum), bookList.get(indexNum), LocalDate.now());
                    lendDetails.add(borrowDetails);
                    bookList.get(indexNum).setIsAvailable(true);
                    System.out.println();
                    System.out.println("    ** Lending Completed **");
                    System.out.println("______________________________________________");
                    System.out.println();
                    borrowDetails.getLendDetails(); 
                    return true;
                }
                else{
                    System.out.println("Invalid member ID");
                }
                
            }
            else{
                System.out.println("Sorry " + bookNum + " ( "+ bookList.get(indexNum).getBookName() + " ) has already been borrowed");
            }
        }
        else{
            System.out.println("Invalid registration number");
            System.out.println();
        }
        return false;
    }

    //bug
    public void RelaventLendDetails(){
        System.out.println("Enter the book register number");
        int bookNum = input.nextInt();

        int indexNum=  BookSearch(bookNum);
        if(indexNum != -1){
            for(int j=0 ; j< lendDetails.size() ; j++){
                if(lendDetails.get(j).getIsLending()){
                   System.out.println("ok");
            }
            else{
                System.out.println("Not Lended");
            }
            }
        }
        else{
            System.out.println("Invalid registration number");
            System.out.println();
        } 
        
    }
  


}
