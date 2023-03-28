package maker;

import java.util.ArrayList;
import java.util.Random;

public class KnockMake implements IMaker
{

    private ArrayList<String> knocked;
    private ArrayList<String> teamIDS;
    private ArrayList<String> reversed;
    private boolean isTwice;

    public KnockMake(ArrayList<String> teamIDs, boolean isTwice)
    {
        knocked = new ArrayList<>();
        if (isTwice) reversed = new ArrayList<>();
        this.teamIDS = teamIDs;
        this.isTwice = isTwice;

        repeater();
        if (isTwice) addReversed();
    }


    public ArrayList<String> getKnocked() {return knocked;}

    public void match()
    {
        int limit = teamIDS.size();

        int homeTeam = new Random().nextInt(limit);
        int awayTeam;
        do {awayTeam = new Random().nextInt(limit);} while (homeTeam == awayTeam);

        knocked.add(teamIDS.get(homeTeam) + "-" + teamIDS.get(awayTeam));
        if (isTwice) reversed.add(teamIDS.get(awayTeam) + "-" + teamIDS.get(homeTeam));

        teamIDS.remove(homeTeam);
        if (homeTeam < awayTeam) teamIDS.remove(awayTeam-1);
        else teamIDS.remove(awayTeam);
    }

    public void passBy()
    {
        knocked.add(teamIDS.get(0));
        teamIDS.remove(0);
    }

    public void addReversed()
    {
        for (String m: reversed) {knocked.add(m);}
    }

    public void repeater()
    {
        while (teamIDS.size() > 0)
        {
            if (teamIDS.size() > 1) match();
            else passBy();
        }
    }
}
