package designPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * BuilderÄ£Ê½£¨Java°æ£©
 */

class Builder {
    public static void main(String[] args) {
        OKClient client = new OKClient.Builder()
                .setDNS("666")
                .addInterpreters("888")
                .build();
    }
}

public class OKClient {

    final String dns;
    final List<String> interpreters;

    public OKClient() {
        this(new Builder());
    }

    public OKClient(Builder builder) {
        this.dns = builder.dns;
        this.interpreters = builder.interpreters;
    }

    public static final class Builder {
        String dns;
        final List<String> interpreters = new ArrayList<>();

        public Builder setDNS(String dns) {
            this.dns = dns;
            return this;
        }

        public Builder addInterpreters(String interpreter) {
            this.interpreters.add(interpreter);
            return this;
        }

        public OKClient build() {
            return new OKClient(this);
        }
    }
}