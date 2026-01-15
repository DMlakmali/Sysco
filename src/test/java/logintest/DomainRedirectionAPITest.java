package logintest;

import loginAPI.DomainRedirectionService;
import org.junit.Assert;
import org.testng.annotations.Test;


public class DomainRedirectionAPITest {

    DomainRedirectionService domainRedirectionService = new DomainRedirectionService();

	@Test
	public void verifyThatCABLOktaEmailsAreRedirectedToCAWhenTheCurrentDomainIsCOM(){


        Assert.assertNotNull(domainRedirectionService.domainReDirection("Test11.Minimaster@corp.sysco.ca", ".com").getData().getGetFeDomainRedirectionUrl().getRedirectTo());


	}

}
