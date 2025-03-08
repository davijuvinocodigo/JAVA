package com.musicstore.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "invoiceline")
public class InvoiceLine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "invoice_line_id")
    private Integer invoiceLineId;
    @Column(name = "invoice_id ")
    private Integer invoiceId;
    @Column(name = "track_id ")
    private Integer trackId;
    @Column(name = "unit_price ")
    private Double unitPrice;
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "invoice_id", referencedColumnName = "invoice_id", insertable = false, updatable = false)
    private Invoice invoice;

    @ManyToOne
    @JoinColumn(name = "track_id", referencedColumnName = "track_id", insertable = false, updatable = false)
    private Track track;
}
