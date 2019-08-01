package com.barton;

/**
 * Properties fields and local variables
 */
public class Book {
    String title;
    int pageCount;
    int ISBN;
    boolean isCheckedOut;
    int dayCheckedOut = -1;

    /**
     * Constructor
     *
     * @param bookTitle
     * @param bookPageCount
     * @param bookISBN
     */
    public Book(String bookTitle, int bookPageCount, int bookISBN) {
        this.title = bookTitle;
        this.pageCount = bookPageCount;
        this.ISBN = bookISBN;
        isCheckedOut = false;
    }

    public String getTitle() {
        return this.title;
    }

    public int getPageCount() {
        return this.pageCount;
    }

    public int getISBN() {
        return this.ISBN;
    }

    public boolean getisCheckedOut() {
        return this.isCheckedOut;
    }

    public int getDayCheckedOut() {
        return this.dayCheckedOut;
    }

    public void setIsCheckedOut(boolean checkedOut, int currentDayCheckOut) {
        this.isCheckedOut = isCheckedOut;
        setDayCheckedOut(currentDayCheckOut);
    }

    public void setDayCheckedOut(int dayCheckedOut) {
        this.dayCheckedOut = dayCheckedOut;
    }
}

