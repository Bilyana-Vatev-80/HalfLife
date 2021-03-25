package halfLife;

import org.junit.Assert;
import org.junit.Test;

public class PlayerTests {
    @Test
    public void testConstructorCreateInstance(){
        Player player = new Player("Pesh", 100);
        Assert.assertNotNull(player);
    }

    @Test
    public void testGetGetUsername(){
        Player player = new Player("Pesho", 100);
        String actualName = player.getUsername();
        String expectedName = "Pesho";
        Assert.assertEquals(expectedName, actualName);
    }

    @Test(expected = NullPointerException.class)
    public void testSetUsernameInvalid(){
        Player player = new Player(null, 100);
    }

    @Test
    public void testGetHealth(){
        Player player = new Player("Pesh", 100);
        int actualHealth = player.getHealth();
        int expectedHealth = 100;

        Assert.assertEquals(expectedHealth, actualHealth);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetInvalidHealth(){
        new Player("Pesh", -100);
    }

    @Test
    public void testGetGuns(){
        Player player = new Player("Gosho", 20);
        int actualLength = player.getGuns().size();
        int expectedLength = 0;
        Assert.assertEquals(expectedLength, actualLength);
    }

//    @Test(expected = IllegalArgumentException.class)
//    public void testTakeDamageBelowZero(){
//        Player player = new Player("Pesh", 100);
//        player.takeDamage(200);
//    }
    
    @Test
    public void testTakeDamage(){
        Player player = new Player("Pesh", 100);
        player.takeDamage(20);
        int actualHealth = player.getHealth();
        int expectedHealth = 80;
        Assert.assertEquals(expectedHealth, actualHealth);
    }

    @Test(expected = NullPointerException.class)
    public void testAddNullGun(){
        Player player = new Player("Pesh", 100);
        player.addGun(null);
    }

    @Test
    public void testValidAddGun(){
        Player player = new Player("Pesh", 100);
        Gun gun = new Gun("rifle", 20);
        player.addGun(gun);
        Gun expectedGun = gun;
        Gun actualGun = player.getGun(gun.getName());
        Assert.assertEquals(expectedGun, actualGun);
    }

    @Test
    public void testRemoveGun(){
        Player player = new Player("Pesh", 100);
        Gun gun = new Gun("rifle", 20);
        player.addGun(gun);
        boolean actualRemove = player.removeGun(gun);
        Assert.assertTrue(actualRemove);
    }

//    @Test
 //   public void testGetInvalidGun(){
//        Player player = new Player("Pesh", 100);
//        Gun gun = new Gun("rifle", 20);
//        player.addGun(gun);
//        Gun expectedGun = null;
//        Gun actualGun = player.getGun("M16");
//        Assert.assertNotNull( actualGun);
//    }
}
