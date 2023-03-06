package builder;

import com.notifier.app.model.User;

public class MockUserBuilder {
    private User user;

    public MockUserBuilder() {
        User user = new User();
        user.setId(1L);
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
