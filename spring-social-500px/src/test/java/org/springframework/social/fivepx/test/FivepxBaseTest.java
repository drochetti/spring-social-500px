package org.springframework.social.fivepx.test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.fivepx.api.Fivepx;
import org.springframework.social.fivepx.test.config.FivepxConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = FivepxConfiguration.class)
public class FivepxBaseTest {

	@Autowired
	protected Fivepx fivepxApi;

}
