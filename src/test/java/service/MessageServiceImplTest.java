package service;

import com.notifier.app.AppApplication;
import com.notifier.app.model.Category;
import com.notifier.app.model.Message;
import com.notifier.app.model.User;
import com.notifier.app.service.MessageServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = AppApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application-test.properties")
public class MessageServiceImplTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private MessageServiceImpl messageService;

    @Test
    public void whenMessageServiceNotify(){
        Message message = new Message();
        Category category = new Category(1L);
        message.setCategory(category);
        User user = new User();
        user.setId(1L);
        message.setUser(user);
        message.setBody("Foo message");
        Mockito.when(messageService.notify(message)).thenReturn(new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY));
    }

}
