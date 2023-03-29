package maker;

import java.util.ArrayList;
import java.util.Random;

public class GroupMake
{

    ArrayList<ArrayList<String>> groups;
    ArrayList<String> teamIDs;
    int teamsPerGroup, amountGroup;
    public GroupMake(ArrayList<String> teamIDs, int amountGroup)
    {
        groups = new ArrayList<>();
        this.teamIDs = teamIDs;
        this.amountGroup = amountGroup;

        if (teamIDs.size() % amountGroup == 0)
        {
            teamsPerGroup = teamIDs.size() / amountGroup;
            make();
        }
    }

    public ArrayList<ArrayList<String>> getGroups() {return groups;}

    private void make()
    {
        for (int i = 0; i < amountGroup; i++)
        {
            ArrayList<String> newGroup = new ArrayList<>();

            for (int j = 0; j < teamsPerGroup; j++)
            {
                int id = new Random().nextInt(teamIDs.size());
                newGroup.add(teamIDs.get(id));
                teamIDs.remove(id);
            }

            groups.add(newGroup);
        }
    }
}
