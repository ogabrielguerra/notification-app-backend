package com.notifier.app.dto;

import com.notifier.app.model.Message;

import java.util.ArrayList;
import java.util.List;

public class Mapper {
    public static List<MessageDTO> toMessageDTOList(List<Message> messagesList) {
        List<MessageDTO> messageDTOList = new ArrayList<>();
        messagesList.forEach(message -> messageDTOList.add(new MessageDTO(message)));
        return messageDTOList;
    }
}
