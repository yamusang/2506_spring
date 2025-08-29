package org.iclass.jpahomework.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Table(name = "community")
@Entity
public class CommunityEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idx;
  @Column(nullable = false)
  private String writer;
  @Column(nullable = false)
  private String title;
  @Column(nullable = false)
  private String content;
  private Integer readcount;
  private LocalDate createdat;
  private String ip;
  private Integer commentcount;

}
