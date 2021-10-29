package com.pixlog.dao;

import java.io.Serializable;

public class User
        implements Serializable {

    private String uuid,
            name,
            email,
            businessName,
            password,
            fv,
            ud,
            uc,
            uv,
            accountType,
            credits,
            accessToken,
            tokenType,
            expiresAt,
            loginAut;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFv() {
        return fv;
    }

    public void setFv(String fv) {
        this.fv = fv;
    }

    public String getUd() {
        return ud;
    }

    public void setUd(String ud) {
        this.ud = ud;
    }

    public String getUc() {
        return uc;
    }

    public void setUc(String uc) {
        this.uc = uc;
    }

    public String getUv() {
        return uv;
    }

    public void setUv(String uv) {
        this.uv = uv;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getCredits() {
        return credits;
    }

    public void setCredits(String credits) {
        this.credits = credits;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public String getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(String expiresAt) {
        this.expiresAt = expiresAt;
    }

    public String getLoginAut() {
        return loginAut;
    }

    public void setLoginAut(String loginAut) {
        this.loginAut = loginAut;
    }
}
