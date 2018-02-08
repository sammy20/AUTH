package fmi.pserasmusip.entity;


import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "role")
@Setter
public class Role {

    private int roleId;

    private String role;

    private Collection<User> users;

    public Role() {
    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getRoleId() {
        return roleId;
    }

    @ManyToMany(mappedBy = "roles")
    public Collection<User> getUsers() {
        return users;
    }

    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
