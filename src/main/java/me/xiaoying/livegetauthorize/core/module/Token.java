package me.xiaoying.livegetauthorize.core.module;

import java.util.Date;

public class Token {
    private final String token;
    private Date save;
    private Date over;
    private final Module module;

    public Token(String token, Date save, Date over, Module module) {
        this.token = token;
        this.save = save;
        this.over = over;
        this.module = module;
    }

    public String getToken() {
        return this.token;
    }

    public Date getSave() {
        return this.save;
    }

    public void setSave(Date date) {
        this.save = date;
    }

    public Date getOver() {
        return this.over;
    }

    public void setOver(Date date) {
        this.over = date;
    }

    public Module getModule() {
        return this.module;
    }

    public boolean overdue() {
        if (this.save == null || this.over == null)
            return false;

        return new Date().getTime() - this.over.getTime() > 0;
    }
}