package agh.ics.oop.model;

public class ConsoleMapDisplay implements MapChangeListener{
    private int changescount;

    public ConsoleMapDisplay() {
        this.changescount = 0;
    }
    @Override
    public void mapChanged(WorldMap worldMap, String message) {
        changescount++;
        System.out.println(message);
        System.out.println(worldMap.toString());
        System.out.println("Number of changes: " + changescount + "\n\n\n");
    }
}
