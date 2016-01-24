package com.nespresso.recruitment.gossip.message;


public class MessageBody {

    private final String content;

    public MessageBody(String content) {
        this.content = content;
    }

    public String content() {
        return content;
    }

    public boolean checkNotEmptyContent() {
        return !(content == null || content.isEmpty());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MessageBody{");
        sb.append("content='").append(content).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
