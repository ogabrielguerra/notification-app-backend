package builder;

import com.notifier.app.model.Category;
import com.notifier.app.model.Message;
import com.notifier.app.model.User;

public class MockMessageBuilder {

    private Message message;
    public void MockMessageBuilder() {
        Long channelId = 1L;
        Message message = new Message();
        Category category = new Category(1L);
        message.setCategory(category);
        User user = new User();
        user.setId(1L);
        message.setUser(user);
        message.setBody("Foo message");
        this.message = message;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}
