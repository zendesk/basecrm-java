package com.getbase;

import static com.getbase.BaseCRM.VERSION;

public class Configuration {

    public static final String PRODUCTION_URL = "https://api.getbase.com";
    public static final String DEFAULT_USER_AGENT = "BaseCRM/v2 Java/" + VERSION;
    public static final int DEFAULT_TIMEOUT = 30;

    private String accessToken;
    private String baseUrl;
    private String userAgent;
    private int timeout;
    private boolean verifySSL;
    private boolean verbose;

    public static Configuration getDefault() {
        return new Configuration(System.getenv("BASECRM_ACCESS_TOKEN"),
                PRODUCTION_URL,
                DEFAULT_USER_AGENT,
                DEFAULT_TIMEOUT,
                true,
                false);
    }

    private Configuration(String accessToken, String baseUrl, String userAgent, int timeout, boolean verifySSL, boolean verbose) {
        this.accessToken = accessToken;
        this.baseUrl = baseUrl;
        this.userAgent = userAgent;
        this.timeout = timeout;
        this.verifySSL = verifySSL;
        this.verbose = verbose;
    }

    public boolean isVerbose() {
        return verbose;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public int getTimeout() {
        return timeout;
    }

    public boolean isVerifySSL() {
        return verifySSL;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public static final class Builder {
        private Configuration config;

        public Builder() {
            this.config = getDefault();
        }

        public Builder verbose(boolean verbose) {
            this.config.verbose = verbose;
            return this;
        }

        public Builder verbose() {
            return verbose(true);
        }

        public Builder baseUrl(String baseUrl) {
            this.config.baseUrl = baseUrl;
            return this;
        }

        public Builder timeout(int timeout) {
            this.config.timeout = timeout;
            return this;
        }

        public Builder verifySSL(boolean verifySSL) {
            this.config.verifySSL = verifySSL;
            return this;
        }

        public Builder verifySSL() {
            return verifySSL(true);
        }

        public Builder userAgent(String userAgent) {
            this.config.userAgent = userAgent;
            return this;
        }

        public Builder accessToken(String accessToken) {
            this.config.accessToken = accessToken;
            return this;
        }

        public Configuration build() {
            return this.config;
        }
    }

}
