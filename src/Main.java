import general.Generator;
import general.Pool;
import general.RunType;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args)
    {

        ArrayList<String> teams = new ArrayList<>();
        teams.add("Real Madrid");
        teams.add("Bayern München");
        teams.add("Milan");
        teams.add("Napoli");
        teams.add("Inter");
        teams.add("Manchester City");
        teams.add("Benfica");
        teams.add("Chelsea");

        Generator generate = new Generator();
        Pool pool = new Pool(teams, RunType.PLAYOFF);
        generate.fixture(pool, true);

        System.out.println(generate.getResult());

    }
}