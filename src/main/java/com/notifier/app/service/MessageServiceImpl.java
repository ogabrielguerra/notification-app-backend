package com.notifier.app.service;

import com.notifier.app.model.Message;

public class MessageServiceImpl implements MessageService{

    public boolean sendByEmail(Message message){
        try{
            return true;
        }catch (Exception e){

        }
        return false;
    }

    public boolean sendBySMS(Message message){
        try{
            return true;
        }catch (Exception e){

        }
        return false;
    }

    public boolean sendByPush(Message message){
        try{
            logMessageSentInDatabase(message);
            return true;
        }catch (Exception e){

        }
        return false;
    }

    private boolean logMessageSentInDatabase(Message message){
        try{
            return true;
        }catch (Exception e){

        }
        return false;
    }

}
