package org.hill.tx.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;

@Entity
@Table(name = "CUSTOMERS")
public class Customer {
    @Id
    @SequenceGenerator(name = "CUSTOMER_GENERATOR", sequenceName = "S_CUSTOMER", allocationSize = 0)
    @GeneratedValue(generator = "CUSTOMER_GENERATOR")
    private long id;
    @Column(name = "F_NAME")
    private String fName;
    @Column(name = "L_NAME")
    private String lName;

    public Customer() {
    }

    public Customer(String fName, String lName) {
        this.fName = fName;
        this.lName = lName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("fName", fName)
                .append("lName", lName)
                .toString();
    }
}
