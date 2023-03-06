package service;

import builder.MockMessageBuilder;
import builder.MockUserBuilder;
import com.notifier.app.AppApplication;
import com.notifier.app.model.Message;
import com.notifier.app.model.MessageLog;
import com.notifier.app.model.User;
import com.notifier.app.model.repository.MessageLogRepository;
import com.notifier.app.service.MessageLogServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = AppApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application-test.properties")
public class MessageLogServiceImplTest {

    @MockBean
    private MessageLogServiceImpl messageLogService;

    @MockBean
    private MessageLogRepository messageLogRepository;

    private Long defaultChannelId;
    private Message mockMessage;
    private User mockUser;

    public MessageLogServiceImplTest() {
        this.defaultChannelId = 1L;
        this.mockMessage = new MockMessageBuilder().getMessage();
        this.mockUser = new MockUserBuilder().getUser();
    }

    @Test
    public void whenMessageLogMessageLogBuilder(){
        Mockito.when(messageLogService.messageLogBuilder(
                this.mockUser, this.mockMessage, this.defaultChannelId)).thenReturn(new MessageLog());
    }

    @Test
    public void whenMessageLogMessageLogMessageSentToChannels(){
        MessageLog messageLog = messageLogService.messageLogBuilder(
                this.mockUser, this.mockMessage, this.defaultChannelId);
        Mockito.when(messageLogRepository.save(messageLog)).thenReturn(new MessageLog());
    }

}
