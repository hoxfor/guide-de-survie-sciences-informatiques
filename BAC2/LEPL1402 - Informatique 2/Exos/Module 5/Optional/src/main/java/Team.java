import java.util.Optional;

public class Team {
    Optional<TeamLeader> teamLeader;
    public Team(){
    }

    public Team(Optional<TeamLeader> teamLeader){
        this.teamLeader = teamLeader;
    }

    public Optional<TeamLeader> getTeamLeader(){
        return this.teamLeader;
    }

    public void setTeamLeader(Optional<TeamLeader> teamLeader){
        this.teamLeader = teamLeader;
    }
}
