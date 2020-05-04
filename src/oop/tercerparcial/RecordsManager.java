package oop.tercerparcial;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RecordsManager {
    private final File recordsFile;

    public RecordsManager(File recordsFile) {
        this.recordsFile = recordsFile;
    }

    public void save(GameRecord record) {

        if(record.getScore() < 0){
            throw new NegativeScoreException();
        }

        if(record.getPlayerName() == null || record.getPlayerName().isEmpty()){
            throw new InvalidPlayerNameException();
        }


        Charset utf8 = StandardCharsets.UTF_8;
        String content = record.getScore() + "," + record.getPlayerName() + System.lineSeparator();

        try (Writer writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(recordsFile, true), utf8)
        )) {

            writer.write(content);
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }

    public List<GameRecord> list() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(recordsFile.getAbsolutePath()));
        List<GameRecord> gameRecords = new ArrayList<>();

        for(String line: lines){
            String[] values = line.split(",");
            GameRecord gameRecord = new GameRecord();

            gameRecord.setScore(Integer.parseInt(values[0]));
            gameRecord.setPlayerName(values[1]);

            gameRecords.add(gameRecord);
        }

        gameRecords.sort((o1, o2) -> o2.getScore() - o1.getScore());

        return gameRecords;
    }
}
