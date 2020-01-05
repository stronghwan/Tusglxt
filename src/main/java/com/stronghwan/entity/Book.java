package com.stronghwan.entity;

import lombok.Data;

/**
 * @Author stronghwan
 * @Verison
 * @Date2019/12/19-13-10
 */
@Data
public class Book {

    private int id;

    private String bookName;

    private String author;

    private String press;

    private String isbn;

    private String category;

    private double price;

}
