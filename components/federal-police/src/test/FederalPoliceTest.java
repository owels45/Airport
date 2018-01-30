import base.Passport;
import base.SpecialGood;
import base.SpecialGoodType;
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
        assertTrue(FederalPolice.getInstance().innerMethodVerify(new Passport("id","picture","string", null)));
    }

    @Test
    void testInnerMethodScanNullPassport() {
        assertFalse(FederalPolice.getInstance().innerMethodScan(null));
    }

    @Test
    void testInnerMethodArrestNotNullPassport() {
        assertTrue(FederalPolice.getInstance().innerMethodScan(new Passport("id","picture","string", null)));
    }

    @Test
    void testInnerMethodInspectWeaponTrue() {
        SpecialGood specialGood = new SpecialGood(SpecialGoodType.Weapon);
        assertTrue(FederalPolice.getInstance().innerMethodInspectWeapon(specialGood));
    }

    @Test
    void testInnerMethodInspectWeaponFalse() {
        SpecialGood specialGood = new SpecialGood(SpecialGoodType.Bike);
        assertFalse(FederalPolice.getInstance().innerMethodInspectWeapon(specialGood));
    }

    @Test
    void testInnerMethodInspectMunitionTrue() {
        SpecialGood specialGood = new SpecialGood(SpecialGoodType.Munition);
        assertTrue(FederalPolice.getInstance().innerMethodInspectMunition(specialGood));
    }

    @Test
    void testInnerMethodInspectMunitionFalse() {
        SpecialGood specialGood = new SpecialGood(SpecialGoodType.DangerousGoods);
        assertFalse(FederalPolice.getInstance().innerMethodInspectMunition(specialGood));
    }

    @Test
    void testInnerMethodKeepSafe() {
    }

    @Test
    void testInnerMethodNotifyGroundOperations() {
    }
}