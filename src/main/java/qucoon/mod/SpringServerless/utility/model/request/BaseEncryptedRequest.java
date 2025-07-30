package qucoon.mod.SpringServerless.utility.model.request;


import java.util.Objects;

public class BaseEncryptedRequest {

    private String payload;

    public BaseEncryptedRequest() {
    }

    public BaseEncryptedRequest(String payload) {
        this.payload = payload;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseEncryptedRequest)) return false;
        BaseEncryptedRequest that = (BaseEncryptedRequest) o;
        return Objects.equals(payload, that.payload);
    }

    @Override
    public int hashCode() {
        return Objects.hash(payload);
    }

    @Override
    public String toString() {
        return "BaseEncryptedRequest{" +
                "payload='" + payload + '\'' +
                '}';
    }
}
