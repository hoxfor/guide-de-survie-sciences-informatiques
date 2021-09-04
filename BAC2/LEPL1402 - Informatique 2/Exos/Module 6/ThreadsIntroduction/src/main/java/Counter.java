public class Counter implements Runnable {

    private int count;
    private int rnd;

    public int getCount() {
        return count;
    }

    public int getRnd(){
        return rnd;
    }

    public Counter(){
        this.count = 0;
        this.rnd = (int) ( (Math.random()*100) + 1000);
    }

    @Override
    public void run() {
        for(int i=0; i< getRnd(); i++){
            count += 1;
        }
    }

}
