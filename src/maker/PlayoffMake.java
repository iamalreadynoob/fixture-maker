package maker;

import java.util.ArrayList;

public class PlayoffMake
{

    ArrayList<String> matches, teamIDs, reversedMatches;

    public PlayoffMake(ArrayList<String> teamIDs, boolean isTwice)
    {
        this.teamIDs = teamIDs;
        matches = new ArrayList<>();
        reversedMatches = new ArrayList<>();

        if (teamIDs.size() % 2 == 0)
        {
            make();
            if (isTwice) matches.addAll(reversedMatches);
        }
    }

    private void make()
    {
        int times = teamIDs.size() / 2;

        for (int i = 0; i < times; i++)
        {
            String match = teamIDs.get(0) + "-" + teamIDs.get(teamIDs.size() - 1);
            String revMatch = teamIDs.get(teamIDs.size() - 1) + "-" + teamIDs.get(0);

            matches.add(match);
            reversedMatches.add(revMatch);

            teamIDs.remove(0);
            teamIDs.remove(teamIDs.size() - 1);
        }
    }

    public ArrayList<String> getMatches() {return matches;}
}
