package test_parking_lot;
import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.main.Parking;

class Test_Parking_Lot  {
	 
	Parking parking = new Parking(6); 

  
	@BeforeEach
    public void setUp() throws Exception {  

		 parking.park("KA-01-HH-1234","White");
	     parking.park("KA-01-HH-9999","White");
	     parking.park("KA-01-BB-0001","Black");
	     parking.park("KA-01-HH-7777","Red");
	     parking.park("KA-01-HH-2701","Blue");
	     parking.park("KA-01-HH-3141","Black");
    } 
	

	@Test
	void leaveTest() {
		
		assertEquals( "Slot number 4 is free",parking.leave(4));
	}
	
	@Test 
	void statusTest() {
		
		String status[] = parking.status();
		String res="";
		
        for(int i = 0 ; i < 6; i++){
            if(status[i] != null) {
            	res = res + status[i] +"\n";

            }
        }
        String expectedOutput = "1		KA-01-HH-1234		White\n" + 
        		"2		KA-01-HH-9999		White\n" + 
        		"3		KA-01-BB-0001		Black\n" + 
        		"4		KA-01-HH-7777		Red\n" + 
        		"5		KA-01-HH-2701		Blue\n" + 
        		"6		KA-01-HH-3141		Black\n" + 
        		"";
      
	assertEquals(expectedOutput,  res);
	}
	
	@Test
	void registrationNumberFromColourTest() {
		assertEquals("KA-01-HH-7777" , parking.getRegistrationNumberFromColour("Red"));
	}
	
	@Test
	void slotNumbersFromcolourTest()
	{
		  assertEquals("4",parking.getSlotNumberFromColour("Red"));
	}
	
	@Test
	void slotnumbersFromRegNumberTest(){
	assertEquals("3" , parking.getSlotNumberFromRegistrationNumber("KA-01-BB-0001"));
	}
}
