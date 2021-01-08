package com.zking.ssm.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.util.Date;

@ToString
public class Book {

    // 书本验证分组
    public static interface ValidateGroups {
        // 新增/修改
        public static interface Add {
        }
        // 上架/下架
        public static interface Edit {
        }
        // 更新封面
        public static interface Delete {
        }
    }
    @NotNull(message = "书本编号不能为空！",groups = {ValidateGroups.Edit.class,ValidateGroups.Delete.class})
    private Integer bookId;

    @NotBlank(message = "书本名称不能为空！",groups = {ValidateGroups.Edit.class,ValidateGroups.Add.class})
    private String bookName;

    @NotNull(message = "书本价格不能为空! ",groups = {ValidateGroups.Edit.class,ValidateGroups.Add.class})
    private Float bookPrice;

    //后台到前端
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getBookImage() {
        return bookImage;
    }

    public void setBookImage(String bookImage) {
        this.bookImage = bookImage;
    }

    private String bookImage;

    public Book(Integer bookId, String bookName, Float bookPrice,String bookImage) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookPrice = bookPrice;
        this.bookImage=  bookImage;
    }



    public Book() {
        super();
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Float getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(Float bookPrice) {
        this.bookPrice = bookPrice;
    }
}