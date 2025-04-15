package org.example.modell;


public class Festmenyek extends Mukincs {
    private String style;
    private String technique;

    public Festmenyek(String id, String author, String title, Category category, int century, String style, String technique) {
        super(id, author, title, category, century);
        this.style = style;
        this.technique = technique;
    }

    public String getStyle() {
        return style;
    }

    public String getTechnique() {
        return technique;
    }

    @Override
    public String getPreparationMethod() {
        return switch (technique.toLowerCase()) {
            case "festék" -> "festék";
            case "szén" -> "szén";
            case "ceruza" -> "ceruza";
            case "vegyes" -> "vegyes";
            default -> "ismeretlen";
        };
    }

    @Override
    public String toString() {
        return super.toString() + ", stílus: " + style + ", technika: " + technique;
    }
}
