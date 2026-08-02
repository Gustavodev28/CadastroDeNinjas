package java10x.CadastroDeNinjas.Missoes;

import jakarta.persistence.*;
import java10x.CadastroDeNinjas.Ninjas.NinjaModel;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
public class MissoesModel {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    private long id;

    private String nomeDaMissao;

    private String dificuldade;

    //Uma missao pode ter varios ninjas
    @OneToMany(mappedBy = "missoes") //chave estrangeira
    private List<NinjaModel> ninjas;


}
