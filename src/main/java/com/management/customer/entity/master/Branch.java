package com.management.customer.entity.master;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "LOOKUP_BRANCH")
public class Branch {
    @Id
    @Column(name="ID")
    private Integer id;
    @Column(name="BRANCH_CODE")
    private String branchCode;
    @Column(name="BRANCH_NAME")
    private String branchName;
    @Column(name="BRANCH_DESCRIPTION")
    private String branchDescription;
    @ManyToMany
    @JoinTable(name="BRANCH_PRODUCT",
            joinColumns = @JoinColumn(name="BRANCH_ID"),
            inverseJoinColumns = @JoinColumn(name="PRODUCT_ID"))
    private List<Product> productsList;


}
