package sheet8;

import java.util.Scanner;

public class Sheet8G2 {
    public static void main(String[] args) {
        PrintedBook book = new PrintedBook(101, "Java Basics", 2020, "John Doe", 350);
        DigitalResource digital = new DigitalResource(202, "OOP Guide", 2023, "PDF", 15.5);

        book.displayInfo();
        System.out.println();
        digital.displayInfo();
        System.out.println();

        System.out.println("PrintedBook late fee for 5 days: " + book.calculateLateFee(5) + " EGP");
        System.out.println("DigitalResource late fee for 5 days: " + digital.calculateLateFee(5) + " EGP");
        System.out.println();

        System.out.println("PrintedBook late fee with 10 EGP discount: " + book.calculateLateFee(5, 10) + " EGP");
        System.out.println("DigitalResource late fee with 5 EGP discount: " + digital.calculateLateFee(5, 5) + " EGP");
        System.out.println();

        System.out.println(book);
        System.out.println(digital);
        System.out.println();

        LibraryItem itemRef = new PrintedBook(103, "Data Structures", 2021, "Jane Smith", 420);
        System.out.println("Polymorphic late fee for 5 days: " + itemRef.calculateLateFee(5) + " EGP");
    }
}

class LibraryItem {
    private int itemId;
    private String title;
    private int publicationYear;

    public LibraryItem(int itemId, String title, int publicationYear) {
        this.itemId = itemId;
        this.title = title;
        this.publicationYear = publicationYear;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public double calculateLateFee(int days) {
        return days * 5;
    }

    public double calculateLateFee(int days, double discount) {
        return calculateLateFee(days) - discount;
    }

    public void displayInfo() {
        System.out.println("ID: " + itemId + ", Title: " + title + ", Year: " + publicationYear);
    }

    public String toString() {
        return "LibraryItem [itemId=" + itemId + ", title=" + title + ", publicationYear=" + publicationYear + "]";
    }
}

class PrintedBook extends LibraryItem {
    private String author;
    private int numberOfPages;

    public PrintedBook(int itemId, String title, int publicationYear, String author, int numberOfPages) {
        super(itemId, title, publicationYear);
        this.author = author;
        this.numberOfPages = numberOfPages;
    }

    public double calculateLateFee(int days) {
        return days * 7;
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.println("Author: " + author + ", Pages: " + numberOfPages);
    }

    public String toString() {
        return "PrintedBook [itemId=" + getItemId() + ", title=" + getTitle() + ", publicationYear=" + getPublicationYear() + ", author=" + author + ", numberOfPages=" + numberOfPages + "]";
    }
}

class DigitalResource extends LibraryItem {
    private String fileFormat;
    private double fileSize;

    public DigitalResource(int itemId, String title, int publicationYear, String fileFormat, double fileSize) {
        super(itemId, title, publicationYear);
        this.fileFormat = fileFormat;
        this.fileSize = fileSize;
    }

    public double calculateLateFee(int days) {
        return days * 3;
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.println("Format: " + fileFormat + ", Size: " + fileSize + " MB");
    }

    public String toString() {
        return "DigitalResource [itemId=" + getItemId() + ", title=" + getTitle() + ", publicationYear=" + getPublicationYear() + ", fileFormat=" + fileFormat + ", fileSize=" + fileSize + "]";
    }
}