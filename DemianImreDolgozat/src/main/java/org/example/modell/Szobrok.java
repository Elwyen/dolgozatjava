package org.example.modell;

public class Szobrok extends Mukincs {
    private String material;

    public Szobrok(String id, String author, String title, Category category, int century, String material) {
        super(id, author, title, category, century);
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }

    @Override
    public String getPreparationMethod() {
        return "szobor/" + material.toLowerCase();
    }

    @Override
    public String toString() {
        return super.toString() + ", anyag: " + material;
    }
}
