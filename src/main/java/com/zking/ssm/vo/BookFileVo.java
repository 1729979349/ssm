package com.zking.ssm.vo;

import com.zking.ssm.model.BookFile;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class BookFileVo extends BookFile {
    private MultipartFile bFile;
    private Integer bookId;
}
