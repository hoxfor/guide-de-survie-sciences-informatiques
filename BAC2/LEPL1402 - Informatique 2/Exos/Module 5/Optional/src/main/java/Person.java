import java.util.Optional;

public class Person {
    Optional<Team> team;

    public Person(){}

    public Person(Optional<Team> team){
        this.team = team;
    }

    public Optional<Team> getTeam(){
        return this.team;
    }

    public void setTeam(Optional<Team> team){
        this.team = team;
    }
}
