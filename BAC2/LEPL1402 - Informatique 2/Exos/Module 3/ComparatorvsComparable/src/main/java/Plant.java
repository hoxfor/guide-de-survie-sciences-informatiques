public class Plant implements Comparable<Plant>{

    private String name;
    private int age;

    public Plant(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    /**
     * Should compare Plant by using name and age in that specific order
     * returns:
     *      > 0 if this is greater than o
     *      0 if they are equal
     *      < 0 if this is less than o
     */
    @Override
    public int compareTo(Plant o) {
        if (this.getName().equals(o.getName())) {
            return Integer.compare(this.getAge(), o.getAge());
        }
        return Integer.compare(this.getName().compareTo(o.getName()), 0);
    }
}
