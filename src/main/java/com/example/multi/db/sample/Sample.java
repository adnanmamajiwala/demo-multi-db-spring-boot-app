package com.example.multi.db.sample;

import lombok.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.Instant;

@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema ="H2DB", name = "SAMPLE")
public class Sample {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;

    private String org;
    private String name;
    private String code;
    private String description;
    private double price;
    private double tax;
    private double start;
    private double end;
    private double total;
    private int quantity;
    private int weight;
    private String batchName;
    private String batchCode;
    private String unit;
    private String brand;
    private String qrCode;

    @Basic
    private Instant createDate;

    @Override
    public boolean equals(Object o) {
        return this == o || o != null && getClass() == o.getClass() && EqualsBuilder.reflectionEquals(this, o);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }
}
