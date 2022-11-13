package com.psg.ramasubramanin.linkedin.cassandra.model;

import com.psg.ramasubramanin.linkedin.cassandra.model.primarykey.PublicationPrimaryKey;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Getter
@Setter
@Table(value = "publication")
public class PublicationDataModel {

    @PrimaryKey
    private PublicationPrimaryKey publicationPrimaryKey;

    @Column(value="title")
    private String title;

    @Column(value="content")
    private String content;

    @Column(value = "year")
    private Integer year;
}
