package agh.ics.oop.model;

public class ConsoleMapDisplay implements MapChangeListener{
    private int changescount = 0;
    @Override
    public synchronized void mapChanged(WorldMap worldMap, String message) {
        changescount++;

        System.out.println(worldMap.getId());
        System.out.println(message);
        System.out.println(worldMap.toString());
        System.out.println("Number of changes: " + changescount + "\n\n\n");
    }
}
