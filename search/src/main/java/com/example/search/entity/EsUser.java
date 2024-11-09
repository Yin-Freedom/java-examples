package com.example.search.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;

import java.io.Serializable;

/**
 * @author freedom
 */
@Document(indexName = "user")
@Setting
@Data
public class EsUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    private String userName;

    private String password;

    private String nickName;

    @Field(type = FieldType.Keyword)
    private Long age;
}
