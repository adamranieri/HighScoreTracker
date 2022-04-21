package dev.ranieri.sortingtests;

import dev.ranieri.models.Score;
import dev.ranieri.util.Sorter;
import dev.ranieri.util.SorterImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SortTests {

    static Sorter sorter = new SorterImpl();

    @Test
    void filter_by_initials(){
        Score score1 = new Score("ACR", 1000);
        Score score2 = new Score("ACR", 1500);
        Score score3 = new Score("KIM", 900);
        List<Score> scoreList = new ArrayList<>();
        scoreList.add(score1);
        scoreList.add(score2);
        scoreList.add(score3);

        List<Score> sortedScores = sorter.filterByInitials(scoreList,"ACR");
        Assertions.assertEquals(2, sortedScores.size());
    }

    @Test
    void sort_by_score(){
        Score score1 = new Score("ACR", 1000);
        Score score2 = new Score("ACR", 1500);
        Score score3 = new Score("KIM", 900);
        List<Score> scoreList = new ArrayList<>();
        scoreList.add(score1);
        scoreList.add(score2);
        scoreList.add(score3);

        List<Score> sortedScores = sorter.sortByPoints(scoreList);
        Assertions.assertEquals(1500, sortedScores.get(0).getPoints());
    }
}
