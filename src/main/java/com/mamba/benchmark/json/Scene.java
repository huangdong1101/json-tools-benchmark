package com.mamba.benchmark.json;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;

public enum Scene {
    text {
        @Override
        public Task newTask(Tool tool, File file, String field) throws IOException {
            String text = Files.asCharSource(file, Charsets.UTF_8).read();
            return () -> tool.readField(text, field);
        }
    },
    bytes {
        @Override
        public Task newTask(Tool tool, File file, String field) throws IOException {
            byte[] bytes = Files.asByteSource(file).read();
            return () -> tool.readField(bytes, field);
        }
    },
    file {
        @Override
        public Task newTask(Tool tool, File file, String field) {
            return () -> tool.readField(file, field);
        }
    };

    public abstract Task newTask(Tool tool, File file, String field) throws IOException;

    interface Task {
        void execute() throws IOException;
    }
}
