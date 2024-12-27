package com.exam.ExamModule4.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;


@Data
@Entity(name = "giao_dich")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Transaction {
    @Id
    @Pattern(regexp = "^MGD-\\d{4}$", message = "Mã giao dịch phải có định dạng MGD-XXXX, trong đó XXXX là 4 chữ số.")
    private String transactionCode;
    @ManyToOne
    @NotNull(message = "Khách hàng không được để trống.")
    @JoinColumn(name = "customer_id") // Tên cột trong DB
    private Customer customerCode;
    @FutureOrPresent(message = "Ngày giao dịch phải là ngày hiện tại hoặc tương lai . Và theo định dạng dd/MM/yyyy")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    private LocalDate date;
    @NotNull(message = "Đơn giá không được để trống.")
    @Min(value = 500001, message = "Đơn giá phải lớn hơn hoặc bằng 500,001 VND.")
    private Double unitPrice;
    @NotNull(message = "Diện tích không được để trống.")
    @Min(value = 20, message = "Diện tích phải lớn hơn hoặc bằng 20 m².")
    private Double acreage;
    @ManyToOne
    @NotNull(message = "Loại dịch vụ không được để trống.")
    @JoinColumn(name = "category_id")
    private Category category;

}
