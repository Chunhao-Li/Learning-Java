package medium.collections;

public interface Stack {
    public void push(Hero h); // add the hero to the end
    public Hero pull(); // get the last hero
    public Hero peek(); // see the last hero
}
