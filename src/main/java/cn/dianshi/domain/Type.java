package cn.dianshi.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "t_type")
public class Type {

    @Id
    @GeneratedValue
    private Long id;
    @NotBlank(message = "类型名称不能为空")
    private String name;

    @OneToMany(mappedBy = "type")
    private List<Blog> blogs = new ArrayList<>();
}
