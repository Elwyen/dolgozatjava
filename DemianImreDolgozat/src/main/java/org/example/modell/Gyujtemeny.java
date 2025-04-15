package org.example.modell;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Gyujtemeny {
    private List<Mukincs> mukincsek;

    public Gyujtemeny() {
        this.mukincsek = new ArrayList<>();
    }

    public void addArtwork(Mukincs a) {
        mukincsek.add(a);
    }

    public List<Mukincs> getGyujtemenyek() {
        return Collections.unmodifiableList(mukincsek);
    }

    public void clear() {
        mukincsek.clear();
    }

    public void saveToFile(File file) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(mukincsek);
        }
    }

    public void loadFromFile(File file) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            Object obj = ois.readObject();
            if (obj instanceof List<?> list) {
                mukincsek.clear();
                for (Object item : list) {
                    if (item instanceof Mukincs a) {
                        mukincsek.add(a);
                    }
                }
            }
        }
    }

    public Map<String, Long> preparationStatistics() {
        return mukincsek.stream()
                .collect(Collectors.groupingBy(
                        Mukincs::getPreparationMethod,
                        Collectors.counting()
                ));
    }

    public List<Mukincs> getSortedByAuthor() {
        return mukincsek.stream()
                .sorted(Comparator.comparing(Mukincs::getAuthor))
                .collect(Collectors.toList());
    }

    public List<Mukincs> getSortedByCentury() {
        return mukincsek.stream()
                .sorted(Comparator.comparingInt(Mukincs::getCentury))
                .collect(Collectors.toList());
    }
}
