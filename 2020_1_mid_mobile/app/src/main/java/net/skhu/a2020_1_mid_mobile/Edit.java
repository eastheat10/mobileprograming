package net.skhu.a2020_1_mid_mobile;

import java.io.Serializable;

public class Edit implements Serializable {
    String body;

    public Edit(String body){
        this.body = body;
    }

    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }

}
