import com.donglan.dao.UserDao;
import com.donglan.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class DataSourceTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void test(){
        List<User> list = userDao.findUser();
        System.out.println(list);
    }
}
