package account;

import java.io.Serializable;

public class AccountUser implements Serializable {
    private static final long serialVersionUID = 7448605884491568546L;
    private String account;
    private String password;

    public AccountUser(String account, String password) {
        this.account = account;
        this.password = password;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "AccountUser{" +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
