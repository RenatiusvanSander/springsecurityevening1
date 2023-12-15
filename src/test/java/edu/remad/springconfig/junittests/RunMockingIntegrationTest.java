package edu.remad.springconfig.junittests;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled
public class RunMockingIntegrationTest extends SpringCoreJUnit5IntegrationTest {

	@Disabled
	@Test
	public void testSuccessfulInitializedServletContext() throws Exception {
		System.out.print(this.webApplicationContext.getServletContext().getServletContextName());
		assertNotNull(this.webApplicationContext, "ServletContext is not null!");
	}

	@Disabled
	@Test
	public void beansTest() throws Exception {
		for(String beanName : this.webApplicationContext.getBeanDefinitionNames()) {
			String beanText = String.format("### %s # loaded bean %s", this.getClass().getName(), beanName);
			System.out.println(beanText);
		}
	}
	
	@Disabled
	@Test
	public void mocksExistTest() throws Exception {
		assertNotNull(servletContext,"servletContext shall not be null!");
		assertNotNull(session,"session shall not be null!");
		assertNotNull(request,"request shall not be null!");
		assertNotNull(response,"response shall not be null!");
		assertNotNull(webRequest,"webRequest shall not be null!");
	}
}
