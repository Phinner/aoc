package fr.xpdustry.aoc.y2022.d01;

import java.util.Collections;

public final class P1ElfListener implements ElfListener {

    private Elf result = Elf.ZERO;

    @Override
    public void onNextElf(final Elf next) {
        if (next.calories() > result.calories()) {
            this.result = next;
        }
    }

    @Override
    public String getResult() {
        return "" + result.calories();
    }
}
