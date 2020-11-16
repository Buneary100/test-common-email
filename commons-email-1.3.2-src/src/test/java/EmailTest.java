import static org.junit.Assert.assertEquals;

import org.apache.commons.mail.EmailException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EmailTest {
	private static String[] TEST_EMAILS = {"ab@bc.com", "a.b@c.org", "abcdefghijklmnopqrst@abcdefghijklmnopqrst.com.bd"};
	private static String[] BAD_ARRAY = {};

	private EmailConcrete email;
	
	@Before
	public void setUpEmailTest() throws Exception{
		email = new EmailConcrete();
	}
	
	@After
	public void tearDownEmailTest() throws Exception{}
	
	//Tests begin here
	
		@Test (expected = EmailException.class )
		public void testAddBccNull() throws Exception{
			email.addBcc(BAD_ARRAY);
		}
		
		@Test
		public void testAddBcc() throws Exception{
			email.addBcc(TEST_EMAILS);
			assertEquals(3, email.getBccAddresses().size());
		}
		
		@Test 
		public void testAddCc() throws Exception{
			email.addCc(TEST_EMAILS[0]);
			assertEquals(1, email.getCcAddresses().size());
		}
}
