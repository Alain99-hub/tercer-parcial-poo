package oop.tercerparcial;

import java.io.File;
import java.util.List;

public class RecordsManager {
    private final File recordsFile;

    public RecordsManager(File recordsFile) {
        this.recordsFile = recordsFile;
    }

    public void save(GameRecord record) {

    }

    public List<GameRecord> list() {
        return null;
    }
}
