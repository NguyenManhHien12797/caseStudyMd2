package account;

import java.io.Serializable;

public class AccountAdmin implements Serializable {
    private static final long serialVersionUID = -4333316296251054416L;

    private String accountAdmin;
    private String passwordAdmin;

    public AccountAdmin(String account, String password) {
        this.accountAdmin = account;
        this.passwordAdmin = password;
    }

    public String getAccountAdmin() {
        return accountAdmin;
    }

    public void setAccountAdmin(String accountAdmin) {
        this.accountAdmin = accountAdmin;
    }

    public String getPasswordAdmin() {
        return passwordAdmin;
    }

    public void setPasswordAdmin(String passwordAdmin) {
        this.passwordAdmin = passwordAdmin;
    }

    @Override
    public String toString() {
        return "AccountAdmin{" +
                "accountAdmin='" + accountAdmin + '\'' +
                ", passwordAdmin='" + passwordAdmin + '\'' +
                '}';
    }
}
