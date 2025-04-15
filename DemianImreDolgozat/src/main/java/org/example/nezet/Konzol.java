package org.example.nezet;

import org.example.modell.*;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class Konzol {

    private Gyujtemeny gyujtemeny;

    public Konzol() {
        gyujtemeny = new Gyujtemeny();
        testData();
    }

    public void konzolraIr() {
        System.out.println("\n--- Üdvözöljük a Műalkotás Gyűjteményben! ---");
        System.out.println("Jelenleg elérhető műalkotások:");
        System.out.println(gyujtemeny.getGyujtemenyek());
    }

    public void FajlbaIr() {
        try {
            gyujtemeny.saveToFile(new File("artworks.bin"));
            System.out.println("Műalkotások mentve a fájlba: artworks.bin");
        } catch (IOException e) {
            System.err.println("Hiba a fájlba írás közben: " + e.getMessage());
        }
    }

    public void statisztika() {
        Map<String, Long> stat = gyujtemeny.preparationStatistics();
        System.out.println("Statisztika (elkészítési mód szerint):");
        stat.forEach((k, v) -> System.out.println(k + " → " + v));
    }

    private void testData() {
        gyujtemeny.addArtwork(new Szobrok("001", "Michelangelo", "Dávid", Category.EREDETI, 21, "márvány"));
        gyujtemeny.addArtwork(new Szobrok("002", "Rodin", "A gondolkodó", Category.EREDETI, 19, "bronz"));
        gyujtemeny.addArtwork(new Festmenyek("003", "Monet", "Tavirózsák", Category.EREDETI, 19, "Impresszionista", "festek"));
        gyujtemeny.addArtwork(new Festmenyek("004", "Dali", "Kitartás emléke", Category.EREDETI, 20, "Szurrealista", "vegyes"));
        gyujtemeny.addArtwork(new Festmenyek("005", "Ismeretlen", "Álomszerű kép", Category.KIS_ERTEKU, 20, "modern", "szén"));
    }

    public void FajlbolBeolvas() {
        try {
            gyujtemeny.loadFromFile(new File("artworks.bin"));
            System.out.println("Műalkotások betöltve a fájlból.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Hiba a fájl beolvasása közben: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        Konzol konzol = new Konzol();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- Menü ---");
            System.out.println("1. Teszt adatok betöltése");
            System.out.println("2. Statisztika megjelenítése");
            System.out.println("3. Mentés fájlba");
            System.out.println("4. Betöltés fájlból");
            System.out.println("5. Kilépés");
            System.out.print("Választás: ");
            String valasz = scanner.nextLine();

            switch (valasz) {
                case "1" -> konzol.konzolraIr();
                case "2" -> konzol.statisztika();
                case "3" -> konzol.FajlbaIr();
                case "4" -> konzol.FajlbolBeolvas();
                case "5" -> running = false;
                default -> System.out.println("Érvénytelen választás!");
            }
        }
        System.out.println("Viszlát!");
    }
}
