package java10x.CadastroDeNinjas.Ninjas;

import jakarta.persistence.*;
import java10x.CadastroDeNinjas.Missoes.MissoesModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Table(name = "tb_cadastro")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString(exclude = "missoes")
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "ID")
    private Long id;

    @Column
    private String nome;

    @Column(unique = true)
    private String email;

    @Column(name = "rank")
    private String rank;


    @Column(name = "idade")
    private int idade;

    @ManyToOne
    @JoinColumn(name = "missoes_id") //chave estrangeira
    private MissoesModel missoes;





}
