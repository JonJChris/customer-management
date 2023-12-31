package com.management.customer.entity.master;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "LOOKUP_BRANCH_TYPE")
public class BranchType {
    @Id
    @Column(name="ID")
    private Integer id;
    @Column(name="BRANCH_CODE")
    private String branchCode;
    @Column(name="BRANCH_NAME")
    private String branchName;
    @Column(name="BRANCH_DESCRIPTION")
    private String branchDescription;
}
