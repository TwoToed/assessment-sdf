package sdf;

public class NextWord {
    private String nextword;
    private Integer count;

    public NextWord(String nextword, Integer count) {
        this.nextword = nextword;
        this.count = count;
    }
    
    public void add() {
        this.count++;
    }
}
