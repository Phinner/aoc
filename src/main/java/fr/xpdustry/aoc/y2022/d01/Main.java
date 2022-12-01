package fr.xpdustry.aoc.y2022.d01;

import fr.xpdustry.aoc.y2022.util.AocRunner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main extends AocRunner {

    public static void main(String[] args) {
        new Main().run();
    }

    @Override
    public void run() {
        final var listeners = List.of(
                new P1ElfListener(),
                new P2ElfListener()
        );

        for (int i = 0; i < listeners.size(); i++) {
            final var listener = listeners.get(i);

            // A more optimal solution would be to convert this loop into an iterator to use it
            // in a stream
            try (final var reader = getAocRessource("input.txt")) {
                final var food = new ArrayList<Food>();
                int id = 1;
                String line;
                while ((line = reader.readLine()) != null) {
                    if (line.isBlank()) {
                        listener.onNextElf(new Elf(id++, food));
                        food.clear();
                    } else {
                        food.add(new Food(Integer.parseInt(line)));
                    }
                }
            } catch (final IOException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Listener #" + (i + 1));
            System.out.println(listener.getResult());
        }
    }
}
