package com.example.hexagonalarchitecture.adapter.out.persistence.account;

import com.example.hexagonalarchitecture.adapter.out.persistence.user.UserEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TBL_ACCOUNT")
public class AccountEntity {

    @Id
    @Column(name = "INDEX")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long index;

    @Column(name = "ACCOUNT_NUM")
    private String accountNum;

    @Column(name = "ACCOUNT_PASSWORD")
    private String accountPassword;

    @Column(name = "MONEY")
    private long money;

    @ManyToOne
    @JoinColumn(name="USER_INDEX")
    private UserEntity user;

    void setMoeny(long money) {
        this.money = money;
    }

}
