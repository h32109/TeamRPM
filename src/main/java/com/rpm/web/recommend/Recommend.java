package com.rpm.web.recommend;

import lombok.*;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Component
@Lazy
@Entity
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="recommend")
public class Recommend implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "RECO_SEQ") @NotNull private Long userSeq;
    @Column(name = "CENTER_REGION", length = 10) private String centerRegion;
    @Column(name = "MIN_BEGIN_YEAR", length = 4) private String minBeginYear;
    @Column(name = "MAX_BEGIN_YEAR", length = 4) private String maxBeginYear;
    @Column(name = "MIN_PRICE", length = 5) private String minPrice;
    @Column(name = "MAX_PRICE", length = 5) private String maxPrice;
    @Column(name = "MIN_MILEAGE", length = 45) private String minMilage;
    @Column(name = "MAX_MILEAGE", length = 45) private String maxMilage;
    @Column(name = "MODELNM", length = 45) private String modelnm;
    @Column(name = "CAR_TYPE", length = 3) private String carType;
    @Column(name = "TRANSMISSIONCD", length = 100) private String transmissioncd;
    @Column(name = "FUEL_TYPED_NAME", length = 9) private String fuleTypedName;
    @Column(name = "MAKENM", length = 20) private String makenm;
    @Column(name = "CATEGORYNM", length = 50) private String categorynm;
    @Column(name = "MODEL_GRP_CD", length = 50) private String modelGrpCd;
}