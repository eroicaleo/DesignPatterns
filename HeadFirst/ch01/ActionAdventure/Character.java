/**
 * Created by yangge on 12/29/2015.
 */
public class Character {
    WeaponBehavior weapon;

    public void fight() {
        weapon.useWeapon();
    }

    public void setWeapon(WeaponBehavior w) {
        this.weapon = w;
    }
}
