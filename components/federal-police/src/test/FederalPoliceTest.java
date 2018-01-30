import dummies.SpecialGood;
import dummies.SpecialGoodType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FederalPoliceTest {

    @Test
    void testGetInstanceNotNull() {
        assertNotNull(FederalPolice.getInstance());
    }

    @Test
    void testInnerMethodVerify() {
    }

    @Test
    void testInnerMethodScan() {
    }

    @Test
    void testInnerMethodArrest() {
    }

    @Test
    void testInnerMethodInspectWeaponTrue() {
        SpecialGood specialGood = new SpecialGood();
        specialGood.specialGoodType = SpecialGoodType.weapon;
        assertTrue(FederalPolice.getInstance().innerMethodInspectWeapon(specialGood));
    }

    @Test
    void testInnerMethodInspectWeaponFalse() {
        SpecialGood specialGood = new SpecialGood();
        specialGood.specialGoodType = SpecialGoodType.bike;
        assertFalse(FederalPolice.getInstance().innerMethodInspectWeapon(specialGood));
    }

    @Test
    void testInnerMethodInspectMunitionTrue() {
        SpecialGood specialGood = new SpecialGood();
        specialGood.specialGoodType = SpecialGoodType.munition;
        assertTrue(FederalPolice.getInstance().innerMethodInspectMunition(specialGood));
    }

    @Test
    void testInnerMethodInspectMunitionFalse() {
        SpecialGood specialGood = new SpecialGood();
        specialGood.specialGoodType = SpecialGoodType.dangerousGoods;
        assertFalse(FederalPolice.getInstance().innerMethodInspectMunition(specialGood));
    }

    @Test
    void testInnerMethodKeepSafe() {
    }

    @Test
    void testInnerMethodNotifyGroundOperations() {
    }
}