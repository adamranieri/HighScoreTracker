package dev.ranieri.app;

import com.google.gson.Gson;
import dev.ranieri.models.Score;
import dev.ranieri.util.Sorter;
import dev.ranieri.util.SorterImpl;
import io.javalin.Javalin;

import java.util.ArrayList;
import java.util.List;

public class App {

    static List<Score> scoreList = new ArrayList<>();
    static Gson gson = new Gson();
    static Sorter sorter = new SorterImpl();

    public static void main(String[] args) {
        Javalin app = Javalin.create();

        app.get("/scores", context -> {
            String initials = context.queryParam("initials");

            if(initials == null){
                String scoreJson = gson.toJson(sorter.sortByPoints(scoreList));
                context.result(scoreJson);
            }else{
                List<Score> sortedScores = sorter.filterByInitials(scoreList, initials);
                String scoreJson = gson.toJson(sortedScores);
                context.result(scoreJson);
            }

        });

        app.post("/scores", context -> {
            String json = context.body();
            Score score = gson.fromJson(json, Score.class);

            if(score.getPoints() <0){
                context.status(400);
                context.result("Score cannot be negative");
            }else{
                scoreList.add(score);
                context.status(201);
                context.result("Score was added!!!");
            }

        });

        app.start(5000);

    }
}
