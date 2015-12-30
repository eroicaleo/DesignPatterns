/**
 * Created by yangge on 12/29/2015.
 */
public class SimUAction {
    public static void main(String[] args) {
        King k = new King();
        k.fight();
        Queen q = new Queen();
        q.fight();
        Knight n = new Knight();
        n.fight();
        Troll t = new Troll();
        t.fight();
        k.setWeapon(new KnifeBehavior());
        k.fight();
    }
}
