package cn.dianshi.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Dianshi
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogQuery {

    private String title;
    private Long typeId;
    private boolean recommend;
}
