package com.shop.fuelcoupons.model.music.entity.error;

import com.google.gson.annotations.SerializedName;

public class ErrorMessage {
    @SerializedName("message")
    private ErrorMessageContainer messageContainer;

    public void setMessageContainer(ErrorMessageContainer messageContainer) {
        this.messageContainer = messageContainer;
    }

    public ErrorMessageContainer getMessageContainer() {
        return messageContainer;
    }
}
