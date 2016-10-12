package com.petukhovsky.tpack.task.source;

import com.petukhovsky.jvaluer.lang.Language;

import java.nio.file.Path;

/**
 * Created by arthur on 12.10.16.
 */
public class Source {
    private final Language language;
    private final Path path;

    public Source(Language language, Path path) {
        this.language = language;
        this.path = path;
    }

    public Language getLanguage() {
        return language;
    }

    public Path getPath() {
        return path;
    }
}
