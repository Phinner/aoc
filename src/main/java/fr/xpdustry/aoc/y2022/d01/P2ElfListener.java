package fr.xpdustry.aoc.y2022.d01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public final class P2ElfListener implements ElfListener {

    private final List<Elf> elves = new ArrayList<>();

    @Override
    public void onNextElf(final Elf next) {
        // I hate it...
        elves.add(next);
    }

    @Override
    public String getResult() {
        final var sum = elves.stream()
                .sorted(Comparator.comparing(Elf::calories))
                .skip(elves.size() - 3)
                .mapToInt(Elf::calories)
                .sum();
        return "" + sum;
    }
}
