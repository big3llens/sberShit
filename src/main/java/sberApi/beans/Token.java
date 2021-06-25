package sberApi.beans;

import java.util.Date;

public class Token {
    private Date issuedDate;
    private Date expiredDate;
    private String token;

    public Token(Date issuedDate, String token) {
        this.issuedDate = issuedDate;
        this.expiredDate = new Date(issuedDate.getTime() + 20 * 60 * 1000);
        this.token = token;
    }

    public Date getIssuedDate() {
//        Date now = System.currentTimeMillis();
//        now.
        return issuedDate;

    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public String getToken() {
        return token;
    }

    public void setIssuedDate(Date issuedDate) {
        this.issuedDate = issuedDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
