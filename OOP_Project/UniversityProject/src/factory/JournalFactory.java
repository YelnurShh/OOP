package factory;

import database.Database;
import models.Journal;

public class JournalFactory {

    public static Journal create(String name) {
        Journal j = new Journal(name);
        Database.getInstance().addJournal(j);
        System.out.println("[FACTORY] New journal created: " + name);
        return j;
    }

    public static Journal createCS() {
        return create("KBTU Computer Science Journal");
    }

    public static Journal createEnergy() {
        return create("KBTU Energy Research");
    }

    public static Journal createBusiness() {
        return create("KBTU Business Review");
    }
}
