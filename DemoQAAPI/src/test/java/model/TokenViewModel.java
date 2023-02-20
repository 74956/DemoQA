package model;

import java.util.Objects;

public class TokenViewModel {
    private String token;
    private String expires;
    private String status;
    private String result;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getExpires() {
        return expires;
    }

    public void setExpires(String expires) {
        this.expires = expires;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TokenViewModel that = (TokenViewModel) o;
        return Objects.equals(token, that.token) && Objects.equals(expires, that.expires) && Objects.equals(status, that.status) && Objects.equals(result, that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(token, expires, status, result);
    }
}
