package com.icia.book.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class BookDTO {
    private Long bookId;
    private String bookName;
    private String bookAuthor;
    private int bookPrice;
    private String bookPublisher;
}
