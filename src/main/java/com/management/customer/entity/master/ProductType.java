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
@Table(name = "LOOKUP_PRODUCT_TYPE")
public class ProductType {
    @Id
    @Column(name="ID")
    private Integer id;
    @Column(name="PRODUCT_CODE")
    private String productCode;
    @Column(name="PRODUCT_NAME")
    private String productName;
    @Column(name="PRODUCT_DESCRIPTION")
    private String productDescription;
    @ManyToMany(mappedBy = "productsList")
    private List<BranchType> branchList;

}
