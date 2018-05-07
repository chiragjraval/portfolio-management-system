package com.pfms.data.transaction;

import com.datastax.driver.core.DataType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Date;
import java.util.UUID;

@Data
@EqualsAndHashCode(of = {"id"})
@ToString(of = {"id", "clientId", "type"})
@Table(value = "transaction")
public class Transaction {

    @PrimaryKey
    private UUID id;

    @CassandraType(type = DataType.Name.TEXT)
    @Column
    private TransactionType type;

    @Column
    private Integer quantity;

    @Column
    private Double price;

    @Column
    private String clientId;

    @Column
    private Date executionDate;

    @Column
    private Date settlementDate;

}
