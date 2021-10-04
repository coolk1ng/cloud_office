import com.gong.OfficeServerApplication;
import com.gong.mapper.MenuMapper;
import com.gong.pojo.Admin;
import com.gong.service.AdminService;
import com.gong.service.MenuService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 测试类
 * 
 * @author CodeSniper
 * @since 2021-09-12
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = OfficeServerApplication.class)
public class Test {
    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private AdminService adminService;

    @org.junit.Test
    public void test(){
        System.out.println(menuMapper.getMenusByAdminId(3));
    }

}
