package com.cmuhatia.playground;


import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TestUtils {

    @SneakyThrows
    public static String readFile(String fileRelativePath, Class<?> clazz) {
        InputStream inputStream = Objects.requireNonNull(
                        clazz.getClassLoader().getResource(fileRelativePath)
                )
                .openStream();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            return reader
                    .lines()
                    .collect(Collectors.joining(System.lineSeparator()));
        }
    }

    public static String[] readFileLines(String fileRelativePath) {
        String rawItems = TestUtils.readFile(fileRelativePath, TestUtils.class);

        return rawItems.split(System.lineSeparator());
    }
}
