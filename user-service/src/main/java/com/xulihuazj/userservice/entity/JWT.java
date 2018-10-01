package com.xulihuazj.userservice.entity;

/**
 * JSON Web Token 实体
 */
public class JWT {

    private String access_toeken;
    private String token_type;
    private String refresh_token;
    private int expires_in;
    private String scope;
    private String jti;

    public String getAccess_toeken() {
        return access_toeken;
    }

    public void setAccess_toeken(String access_toeken) {
        this.access_toeken = access_toeken;
    }

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getJti() {
        return jti;
    }

    public void setJti(String jti) {
        this.jti = jti;
    }
}
