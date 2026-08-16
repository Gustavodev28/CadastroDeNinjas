package java10x.CadastroDeNinjas.Missoes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "ID")
    private Long id;
    @Column(name = "Nome_da_missao")
    private String nomeDaMissao;
    @Column(name = "Dificuldade")
    private String dificuldade;

    //Uma missao pode ter varios ninjas
    @OneToMany(mappedBy = "missoes") //chave estrangeira
    @JsonIgnore
    private List<NinjaModel> ninjas;


}
