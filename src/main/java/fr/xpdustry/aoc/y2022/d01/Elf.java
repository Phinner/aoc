package fr.xpdustry.aoc.y2022.d01;

import java.util.Collections;
import java.util.List;

public record Elf(int id, List<Food> food) {

    public static final Elf ZERO = new Elf(0, Collections.emptyList());

    public Elf(int id, final List<Food> food) {
        this.id = id;
        this.food = List.copyOf(food);
    }

    public int calories() {
        return food.stream().mapToInt(Food::calories).sum();
    }
}
