package com.example.hexagonalarchitecture.adapter.out.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TBL_ACCOUNT_INFO")
class AccountEntity {

    @Id
    @Column(name = "TBL_INDEX")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long index;

    // DB 상 연관관계를 맺고 있지만 Entity 는 맺지 않는다
    @Column(name = "USER_INDEX")
    private Long userIndex;

    @Column(name = "ACCOUNT_NUM")
    private String accountNum;

    @Column(name = "ACCOUNT_PASSWORD")
    private String accountPassword;

    @Setter
    @Column(name = "MONEY")
    private long money;

    public boolean withdraw(long inputMoney) {
        this.money -= inputMoney;
        return this.money >= 0;
    }

    public void deposit(long inputMoney) {
        this.money += inputMoney;
    }


}
