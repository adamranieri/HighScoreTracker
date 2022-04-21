package dev.ranieri.util;

import dev.ranieri.models.Score;

import java.util.List;

public interface Sorter {

    List<Score> filterByInitials(List<Score> scores, String initials);

    List<Score> sortByPoints(List<Score> scores);

}
