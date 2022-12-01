package fr.xpdustry.aoc.y2022.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public abstract class AocRunner implements Runnable {

    private final String root = getClass().getPackageName().replace('.', '/') + '/';

    public BufferedReader getAocRessource(final String name) {
        final var stream = getClass().getClassLoader()
                .getResourceAsStream(root + name);
        if (stream == null) {
            throw new RuntimeException("Failed to find " + name + " in " + this.root);
        }
        final var reader = new InputStreamReader(stream, StandardCharsets.UTF_8);
        return new BufferedReader(reader);
    }
}
