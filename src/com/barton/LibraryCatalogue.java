package com.barton;

import java.util.HashMap;
import java.util.Map;

public class LibraryCatalogue {
    /**
     * Map is like a dictionary it has a word and then a definition to it
     *
     * In this case it has we have string which will be a title and data associated with that book
     * shown below
     */
    Map<String, Book> bookCollection = new HashMap<String, Book>();
    int currentDay = 0;
    int lengthOfCheckoutPeriod = 7;
    double initialLateFee = 0.50;
    double feePerLateDay = 1.00;

    public LibraryCatalogue(Map<String, Book> bookCollection) {
        this.bookCollection = bookCollection;
    }

    public LibraryCatalogue(Map<String, Book> bookCollection, int currentDay, int lengthOfCheckoutPeriod, double initialLateFee, double feePerLateDay) {
        this.bookCollection = bookCollection;
        this.currentDay = currentDay;
        this.lengthOfCheckoutPeriod = lengthOfCheckoutPeriod;
        this.initialLateFee = initialLateFee;
        this.feePerLateDay = feePerLateDay;
    }

    public int getCurrentDay() {
        return this.currentDay;
    }

    public Map<String, Book> getBookCollection() {
        return this.bookCollection;
    }

    public Book getBook(String bookTitle) {
        return this.getBookCollection().get(bookTitle);
    }

    public int getLengthOfCheckoutPeriod() {
        return this.lengthOfCheckoutPeriod;
    }

    public double getInitialLateFee() {
        return this.initialLateFee;
    }

    public double getFeePerLateDay() {
        return this.feePerLateDay;
    }

    public void nextDay() {
        currentDay++;
    }

    public void setDay(int day) {
        currentDay = day;
    }

    public void checkOutBook(String title) {
        Book book = getBook(title);
        if (book.getisCheckedOut()) {
            sorryBookAlreadyCheckedOut(book);
        } else {
            book.setIsCheckedOut(true, currentDay);
            System.out.println("You just checked out" + title + ". It is due on day " + (getCurrentDay() + getLengthOfCheckoutPeriod()+"."));
        }
    }
    public void returnBook(String title) {
        Book book = getBook(title);
        int daysLate = currentDay - (book.getDayCheckedOut() + getLengthOfCheckoutPeriod());
        if(daysLate > 0){
            System.out.println("You owe the library $" + (getInitialLateFee() + daysLate * getFeePerLateDay()) + " because your book is " + daysLate + " days Overdue.");
        } else{
            System.out.println("Book returned. Thank you");
        }
        book.setIsCheckedOut(false, -1);
    }

    private void sorryBookAlreadyCheckedOut(Book book) {
        System.out.println("Sorry, " + book.getTitle()+ " is already checked out. " + "It should be back on day " + (book.getDayCheckedOut() + getLengthOfCheckoutPeriod()) + ". ");

    }

    public static void main(String[] args) {
        Map<String, Book>bookCollection = new HashMap<String, Book>();
        Book Richard = new Book("Richard Dawkins", 4555666, 112);
        bookCollection.put("Richard Dawkins", Richard);
        LibraryCatalogue lib = new LibraryCatalogue(bookCollection);
        lib.nextDay();
        lib.nextDay();
        lib.checkOutBook("Richard Dawkins");
        lib.setDay(12);
        lib.returnBook("Richard Dawkins");
        lib.checkOutBook("Richard Dawkins");
    }

}

