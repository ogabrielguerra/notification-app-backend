package com.notifier.app.model;

import com.notifier.app.model.repository.MessageRepository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class DataLoader {

    final MessageRepository messageRepository;
    private List<String> bodyList;
    private Random random;

    public DataLoader(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
        this.random = new Random();
        setMessages();
        for (int i = 0; i < 30; i++) {
            Message message = messageBuilder((long) getRandomNumberFromRange(1, 4));
            messageRepository.save(message);
        }
    }

    private void setMessages() {
        this.bodyList = new ArrayList<>();
        this.bodyList.add("Hey, what's up?");
        this.bodyList.add("Did you see the last episode from our Podcast?");
        this.bodyList.add("I hope you're feeling better");
        this.bodyList.add("I hope you get better soon");
        this.bodyList.add("What's the version of Java you're using?");
        this.bodyList.add("Thanks for your last message.");
        this.bodyList.add("Sure, will do as soon as I finish this task.");
        this.bodyList.add("Yeah, about the ticket we're working on, I believe we're going to finish earlier.");
        this.bodyList.add("Hmmmm, I really don't know, but I'll try to figure out a solution.");
        this.bodyList.add("Do you think it's feasible?");
        this.bodyList.add("What are the risks for the ticket?");
        this.bodyList.add("I don't think there are risks for the project. We are more than on track about that.");
        this.bodyList.add("I think it's possible, however we'll need to think more carefully about what our priorities are.");
        this.bodyList.add("Stocks are melting now. Take a look in asian markets.");
        this.bodyList.add("Investors are looking for more reliable options due to the risk of war.");
        this.bodyList.add("NBA is going to halt all contracts which are not compliant with the new rules.");
    }

    private Message messageBuilder(Long userId) {
        Message message = new Message();
        message.setMessageType(new MessageType((long) getRandomNumberFromRange(1, 4)));
        message.setChannel(new Channel((long) getRandomNumberFromRange(1, 4)));
        message.setSessionId("xGhjsyg");
        message.setUser(new NotifierUser(userId));
        message.setBody(getRandomMessageBody());
        Date date = new Date();
        message.setCreatedAt(new Timestamp(date.getTime()));
        return message;
    }

    private String getRandomMessageBody() {
        return this.bodyList.get(getRandomNumberFromRange(0, bodyList.size()));
    }

    private int getRandomNumberFromRange(int min, int max) {
        return random.nextInt(min, max);
    }

}
