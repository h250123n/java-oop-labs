enum Level { LOW, MEDIUM, HIGH }

public class LevelDemo {

    static void advise(Level level) {
        switch (level) {
            case LOW -> System.out.println("LOW: relax, no action needed.");
            case MEDIUM -> System.out.println("MEDIUM: keep an eye on things.");
            case HIGH -> System.out.println("HIGH: act now.");
        }
    }

    public static void main(String[] args) {
        for (Level level : Level.values()) {
            advise(level);
        }
    }
}
