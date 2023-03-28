package maker;

import java.util.ArrayList;

public class FixMake implements IMaker
{

    private ArrayList<String> fixture, teamIDs, matches, reversedMatches;
    private ArrayList<Integer> home, away;

    public FixMake(ArrayList<String> teamIDs, boolean isTwice)
    {
        fixture = new ArrayList<>();
        home = new ArrayList<>();
        away = new ArrayList<>();
        matches = new ArrayList<>();
        reversedMatches = new ArrayList<>();

        this.teamIDs = teamIDs;

        all();
        repeater();

        if (isTwice) fill();
        else fixture = matches;
    }

    public ArrayList<String> getFixture() {return fixture;}

    @Override
    public void match()
    {
        ArrayList<String> counted = new ArrayList<>();
        ArrayList<Integer> playedID = new ArrayList<>();

        while (teamIDs.size() != counted.size())
        {
            int homeTeam, awayTeam;
            Integer nextMatch = null;
            for (int i = 0; i < teamIDs.size(); i++)
            {
                if (!isCounted(teamIDs.get(i), counted))
                {
                    nextMatch = i;
                    break;
                }
            }

            int matchID = matchID(nextMatch, playedID);

            homeTeam = home.get(matchID);
            awayTeam = away.get(matchID);

            counted.add(teamIDs.get(homeTeam));
            counted.add(teamIDs.get(awayTeam));

            playedID.add(homeTeam);
            playedID.add(awayTeam);

            matches.add(teamIDs.get(homeTeam) + "-" + teamIDs.get(awayTeam));
            reversedMatches.add(teamIDs.get(awayTeam) + "-" + teamIDs.get(homeTeam));

            home.remove(matchID);
            away.remove(matchID);
        }

    }

    public void all()
    {
        for (int i = 0; i < teamIDs.size(); i++)
        {
            for (int j = i+1; j < teamIDs.size(); j++)
            {
                home.add(i);
                away.add(j);
            }
        }
    }

    @Override
    public void passBy()
    {

    }

    @Override
    public void repeater()
    {
        for (int i = 0; i < teamIDs.size() - 1; i++)
        {
            match();
        }
    }

    private boolean isCounted(String teamID, ArrayList<String> counted)
    {
        boolean isCounted = false;

        for (String t: counted)
        {
            if (teamID.equals(t))
            {
                isCounted = true;
                break;
            }
        }

        return isCounted;
    }

    private int matchID(int teamID, ArrayList<Integer> playedID)
    {
        Integer id = null;

        for (int i = 0; i < home.size(); i++)
        {
            boolean isOkay = false;

            if ((home.get(i) == teamID))
            {
                boolean temp = true;
                for (Integer t: playedID)
                {
                    if (t == away.get(i))
                    {
                        temp = false;
                        break;
                    }
                }

                isOkay = temp;
            }

            else if ((away.get(i) == teamID))
            {
                boolean temp = true;
                for (Integer t: playedID)
                {
                    if (t == home.get(i))
                    {
                        temp = false;
                        break;
                    }
                }

                isOkay = temp;
            }

            if (isOkay)
            {
                id = i;
                break;
            }
        }

        return id;
    }

    private void fill()
    {
        int loc = 0;

        for (int i = 0; i < (teamIDs.size() - 1) * 2; i++)
        {
            if (loc >= matches.size()) {loc = 0;}

            if ((i + 2) % 2 == 0)
            {
                String week = null;

                for (int j = 0; j < teamIDs.size() / 2; j++)
                {
                    if (week == null) week = matches.get(loc);
                    else week += "," + matches.get(loc);
                    loc++;
                }
                fixture.add(week);
            }
            else
            {
                String week = null;
                for (int j = 0; j < teamIDs.size() / 2; j++)
                {
                    if (week == null) week = reversedMatches.get(loc);
                    else week += "," + reversedMatches.get(loc);
                    loc++;
                }
                fixture.add(week);
            }
        }
    }
}
