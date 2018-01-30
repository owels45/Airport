import dummies.Passport;
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
    void testInnerMethodVerifyNullPassport() {
        assertFalse(FederalPolice.getInstance().innerMethodVerify(null));
    }

    @Test
    void testInnerMethodVerifyNotNullPassport() {
        assertTrue(FederalPolice.getInstance().innerMethodVerify(new Passport()));
    }

    @Test
    void testInnerMethodScanNullPassport() {
        assertFalse(FederalPolice.getInstance().innerMethodScan(null));
    }

    @Test
    void testInnerMethodArrestNotNullPassport() {
        assertTrue(FederalPolice.getInstance().innerMethodScan(new Passport()));
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