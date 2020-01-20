package com.mamba.benchmark.json;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    @Parameter(names = {"-c"}, required = true)
    private int c = 1;

    @Parameter(names = {"-n"}, required = true)
    private int n = 1000;

    @Parameter(names = {"-t"}, required = true)
    private Scene scene;

    @Parameter(names = {"-f"}, required = true)
    private File jsonFile;

    @Parameter(required = true)
    private Tool jsonTool;

    public void execute() throws Exception {
        assert this.c > 0;
        assert this.n > 0;
        assert this.n % this.c == 0;

        Scene.Task task = scene.newTask(this.jsonTool, this.jsonFile, "errno");
        ExecutorService executorService = Executors.newFixedThreadPool(this.n);
        List<Future<Long>> futures = new ArrayList<>(this.n);
        futures.add(executorService.submit(new Task(task, this.n / this.c)));
        long costs = 0;
        for (Future<Long> future : futures) {
            costs += future.get();
        }
        executorService.shutdownNow();
        System.out.println(this.jsonTool.desc() + " (" + this.scene.name() + ") 并发：" + this.c + "，累计：" + this.n / this.c * this.c + "次，耗时：" + costs + "毫秒");
    }

    public static void main(String... args) throws Exception {
        Main main = new Main();
        JCommander.newBuilder().addObject(main).build().parse(args);
        main.execute();
    }

    private static class Task implements Callable<Long> {

        private final Scene.Task task;

        private final int n;

        public Task(Scene.Task task, int n) {
            this.task = task;
            this.n = n;
        }

        @Override
        public Long call() throws Exception {
            long beginTime = System.currentTimeMillis();
            for (int i = 0; i < this.n; i++) {
                this.task.execute();
            }
            long endTime = System.currentTimeMillis();
            return endTime - beginTime;
        }
    }
}
