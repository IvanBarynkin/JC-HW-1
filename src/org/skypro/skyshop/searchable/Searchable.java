package org.skypro.skyshop.searchable;

public interface Searchable {

    String searchTerm();

    String searchContentType();

    String searchName();

    default void getStringRepresentation() {
        System.out.println("Имя - " + this.searchName() + " , тип объекта - " + this.searchContentType());
    }
}
