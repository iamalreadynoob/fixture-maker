package general;

import java.util.ArrayList;

public class Pool
{

    private ArrayList<String> teamIDs;
    private RunType type;

    public Pool(ArrayList<String> teamIDs, RunType type)
    {
        this.teamIDs = teamIDs;
        this.type = type;
    }

    public ArrayList<String> getTeamIDs() {return teamIDs;}
    public RunType getType() {return type;}
}
