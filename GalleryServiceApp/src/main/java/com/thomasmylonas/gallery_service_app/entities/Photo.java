package com.thomasmylonas.gallery_service_app.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "Photo")
@Table(name = "Photos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Photos_Id_Seq_Generator")
    @SequenceGenerator(name = "Photos_Id_Seq_Generator", sequenceName = "Photos_Id_Seq", initialValue = 1, allocationSize = 1)
    @Column(name = "Id")
    private Long id;

    @Column(name = "Album_Id")
    private Long albumId;

    @Column(name = "Title")
    private String title;

    @Column(name = "Url")
    private String url;

    @Column(name = "Thumbnail_Url")
    private String thumbnailUrl;
}
