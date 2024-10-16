package agh.ics.oop.model;

import agh.ics.oop.Simulation;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.Executors.newFixedThreadPool;

public class SimulationEngine{

    ExecutorService simulatorExecutor = null;
    List <Simulation> simulationList = new ArrayList<>();
    List <Thread> simulationThreads = new ArrayList<>();
    public SimulationEngine(List<Simulation> simulationList){
        this.simulationList = simulationList;
    }
    public void runSync(){
        for(Simulation simulation : simulationList){
            simulation.run();
        }
    }
    public void runAsync() {
        for(Simulation simulation : simulationList) {
            Thread thread = new Thread(simulation);
            simulationThreads.add(thread);
            thread.start();
        }
    }
    public void awaitSimulationsEnds() throws InterruptedException
    {
        for(Thread thread : simulationThreads) {
            thread.join();
        }

        if(simulatorExecutor != null) {
            simulatorExecutor.shutdown();
            if (!simulatorExecutor.awaitTermination(10, TimeUnit.SECONDS)) {
                simulatorExecutor.shutdownNow();
            }
        }
    }
    public void runAsyncInThreadPool(){
        simulatorExecutor = newFixedThreadPool(4);
        simulationList.forEach(simulatorExecutor :: submit);
    }
}
