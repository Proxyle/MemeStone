package api.model;

import javax.persistence.*;

//@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String userName;
    private String password;
    private String email;
    private Setting setting;

    public Player() {}

    public Player(Long id, String userName, String password, String email, Setting setting) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.setting = setting;
    }
}
