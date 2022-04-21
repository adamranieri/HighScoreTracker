package dev.ranieri.util;

import dev.ranieri.models.Score;

import java.util.List;
import java.util.stream.Collectors;

public class SorterImpl implements Sorter{

    @Override
    public List<Score> filterByInitials(List<Score> scores, String initials) {
        List<Score> sortedList = scores.stream().filter(s -> s.getInitials().equals(initials)).collect(Collectors.toList());
        return sortedList;
    }

    @Override
    public List<Score> sortByPoints(List<Score> scores) {
        List<Score> sortedList = scores.stream().sorted((s1,s2)->{
            if(s1.getPoints()<s2.getPoints()){
                return 1;
            }
            if(s1.getPoints()>s2.getPoints()){
                return -1;
            }
            return 0;
        }).collect(Collectors.toList());
        return sortedList;
    }
}
