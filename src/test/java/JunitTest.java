import com.lmandy.bean.AccountSystemUser;
import com.lmandy.service.backstage.ISystemUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by 94993 on 2017/2/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/applicationContext.xml"})
public class JunitTest {

    @Autowired
    private ISystemUserService iSystemUserService;

    @Test
    public void test(){
        AccountSystemUser user = iSystemUserService.getByName();

        System.out.println(user);


    }
}
