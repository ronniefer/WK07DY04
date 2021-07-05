import java.util.ArrayList;
import java.util.List;

public class Library {
    private String address;
    private String hours;
    //private List<Book> books;
    private List<Book> books = new ArrayList<Book>();
    
	public Library(String libAddress) {
		this.address = libAddress;
	}
	
	public Library(String libAddress, String libHours, List<Book> libCollection) {
		this.address = libAddress;
		this.hours = libHours;
		this.books = libCollection;
	}

	public void addBook(Book bookObject) {
		this.books.add(bookObject);
	}

	public static void printOpeningHours() {
		System.out.println("Libraries are open daily from 9am to 5pm.");
	}
	
	public void printAddress() {
		System.out.println(this.address);
	}
	
	public void borrowBook(String bookTitle) {
		
		boolean titleFound = false;
		
		for (Book bookItem : books) {
			
			if (bookItem.title == bookTitle) {
				
				titleFound = true;
				
				if (bookItem.isBorrowed()) {
					System.out.println("Sorry, this book is already borrowed.");		
			    } else {
			    	bookItem.borrowed = true;
					System.out.println("You successfully borrowed " + bookTitle);	
			    }
			} 
		}
		
		if (!titleFound) {
			System.out.println("Sorry, this book is not in our catalog.");
		}
		
	}
	
	public void returnBook(String bookTitle) {
		
		boolean titleFound = false;
		
		for (Book bookItem : books) {
			
			if (bookItem.title == bookTitle) {
				
				titleFound = true;
				
				if (bookItem.isBorrowed()) {
					bookItem.borrowed = false;
					System.out.println("You successfully returned " + bookTitle);				
			    } else {
			    	System.out.println("Sorry, this book was already returned.");						
			    }
			} 
		}
		
		if (!titleFound) {
			System.out.println("Sorry, this book is not in our catalog.");
		}
		
	}
	
	public void printAvailableBooks() {
		
		if (this.books.size() > 0) {
			for (Book bookItem : books) {
				if (!bookItem.isBorrowed()) {
					System.out.println(bookItem.title);
				}
			}			
		} else {
			System.out.println("No book in catalog");
		}

	}
	
    public static void main(String[] args) {
        // Create two libraries
        Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");

        // Add four books to the first library
        firstLibrary.addBook(new Book("The Da Vinci Code"));
        firstLibrary.addBook(new Book("Le Petit Prince"));
        firstLibrary.addBook(new Book("A Tale of Two Cities"));
        firstLibrary.addBook(new Book("The Lord of the Rings"));

        // Print opening hours and the addresses
        System.out.println("Library hours:");
        printOpeningHours();
        System.out.println();

        System.out.println("Library addresses:");
        firstLibrary.printAddress();
        secondLibrary.printAddress();
        System.out.println();

        // Try to borrow The Lords of the Rings from both libraries
        System.out.println("Borrowing The Lord of the Rings:");
        firstLibrary.borrowBook("The Lord of the Rings");
        firstLibrary.borrowBook("The Lord of the Rings");
        secondLibrary.borrowBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of all available books from both libraries
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second library:");
        secondLibrary.printAvailableBooks();
        System.out.println();

        // Return The Lords of the Rings to the first library
        System.out.println("Returning The Lord of the Rings:");
        firstLibrary.returnBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of available from the first library
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
    }
} 