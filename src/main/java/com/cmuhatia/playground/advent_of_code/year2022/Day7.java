package com.cmuhatia.playground.advent_of_code.year2022;

import lombok.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @see <a href="https://adventofcode.com/2022/day/7">Advent of Code 2022 Day 7</a>
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Day7 {

    public static long getDirSumWithAtMost100000(String[] input) {
        SantaDir root = mountFiles(input);

        AtomicLong sum = new AtomicLong(0);

        sumDirExceedingThreshold(root, sum);

        return sum.get();
    }

    private static long sumDirExceedingThreshold(final SantaDir dir, AtomicLong sum) {
        int total = 0;

        for (SantaDir child : dir.getDirs()) {
            long childTotal = sumDirExceedingThreshold(child, sum);
            if (childTotal <= 100000) {
                sum.addAndGet(childTotal);
            }

            total += childTotal;
        }

        for (SantaFile file : dir.getFiles()) {
            total += file.getSize();
        }

        return total;
    }

    public static long getSmallestDirWithAtLeast(long deviceSize, long minRequiredSize, String[] input) {
        SantaDir root = mountFiles(input);

        long rootSize = getDirSize(root);
        long remain = minRequiredSize - (deviceSize - rootSize);

        AtomicLong currentSize = new AtomicLong(Long.MAX_VALUE);
        getSmallestDirWithAtLeast(remain, root, currentSize);

        return currentSize.get();
    }

    private static long getDirSize(SantaDir dir) {
        long total = 0;

        for (SantaDir child : dir.getDirs()) {
            long childTotal = getDirSize(child);
            total += childTotal;
        }

        for (SantaFile file : dir.getFiles()) {
            total += file.getSize();
        }

        return total;
    }

    private static long getSmallestDirWithAtLeast(long size, SantaDir dir, AtomicLong currentSize) {
        long total = 0;

        for (SantaDir child : dir.getDirs()) {
            total += getSmallestDirWithAtLeast(size, child, currentSize);
        }

        for (SantaFile file : dir.getFiles()) {
            total += file.getSize();
        }

        if (size <= total && total < currentSize.get()) {
            currentSize.set(total);
        }

        return total;
    }

    private static SantaDir mountFiles(String[] input) {
        SantaDir currentDir = new SantaDir("/");

        changeDirectory(input, currentDir);

        return currentDir;
    }

    private static void changeDirectory(String[] input, final SantaDir root) {
        SantaDir currentDir = root;

        for (String line : input) {
            if (line.matches("\\$ cd ..") && currentDir.getParent() != null) {
                currentDir = currentDir.getParent();
            } else if (line.matches("\\$ cd \\w+")) {
                String dirName = line.substring(line.lastIndexOf(" ")).trim();
                currentDir = currentDir.addChild(dirName);
            }

            if (line.matches("\\d+ \\w+.*")) {
                String[] fileParts = line.split("\\s");
                SantaFile santaFile = new SantaFile(fileParts[1], Long.parseLong(fileParts[0]));
                currentDir.getFiles().add(santaFile);
            }
        }
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Setter
    @Getter
    public static class SantaDir {
        private String name;
        private Set<SantaDir> dirs = new HashSet<>();
        private Set<SantaFile> files = new HashSet<>();

        private SantaDir parent;

        public SantaDir(String name) {
            this.name = name;
        }

        public void addChild(SantaDir child) {
            child.parent = this;
            dirs.add(child);
        }

        public SantaDir addChild(String dirName) {
            Optional<SantaDir> exists = dirs.stream().filter(it -> Objects.equals(it.getName(), dirName)).findAny();
            if (exists.isPresent()) {
                return exists.get();
            }

            SantaDir child = new SantaDir(dirName);
            this.addChild(child);

            return child;
        }
    }

    @AllArgsConstructor
    @Getter
    @Setter
    public static class SantaFile {
        private String name;
        private long size;
    }
}
