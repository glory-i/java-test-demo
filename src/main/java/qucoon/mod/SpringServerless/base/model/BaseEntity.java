//package qucoon.mod.SpringServerless.base.model;
//
//
//import javax.persistence.*;
//import lombok.*;
//import java.time.LocalDateTime;
//
//@MappedSuperclass
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
//public abstract class BaseEntity {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//
//    @Column(nullable = false, updatable = false)
//    private LocalDateTime dateCreated = LocalDateTime.now();
//
//    private String createdBy;
//    private String createdByIp;
//
//    private LocalDateTime dateModified;
//    private String modifiedBy;
//    private String modifiedByIp;
//
//    @Column(nullable = false)
//    private boolean isDeleted = false;
//
//    @Column(nullable = false)
//    private boolean isActive = true;
//}
