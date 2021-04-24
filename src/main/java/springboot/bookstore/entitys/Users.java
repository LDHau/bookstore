package springboot.bookstore.entitys;


import springboot.bookstore.entitys.OrderDetail;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @OneToMany
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "USER_ID_FK"))
    private List<OrderDetail> orderDetails = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "ORDER_ID_FK"))
    private List<Orders> ordersList = new ArrayList<>();
}
