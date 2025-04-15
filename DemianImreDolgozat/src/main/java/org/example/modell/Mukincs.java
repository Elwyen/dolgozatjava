package org.example.modell;

import java.io.Serializable;

public abstract class Mukincs implements Serializable {
    protected String id;
    protected String author;
    protected String title;
    protected Category category;
    protected int century;

    public Mukincs(String id, String author, String title, Category category, int century) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.category = category;
        this.century = century;
    }

    public String getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public Category getCategory() {
        return category;
    }

    public int getCentury() {
        return century;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public abstract String getPreparationMethod();

    @Override
    public String toString() {
        return String.format("[%s] %s: %s (%s), %d. század",
                this.getClass().getSimpleName(), author, title, category.name(), century);
    }
}
