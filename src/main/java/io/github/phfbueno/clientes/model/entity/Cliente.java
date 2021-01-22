package io.github.phfbueno.clientes.model.entity;

import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id;

    @Column(nullable = false, length = 150)
    @NotEmpty(message = "{campo.nome.obrigatorio}")
    private String nome;
    
    @Column(length = 11)
    @NotNull(message = "{campo.CPF.obrigatorio}")
    @CPF(message = "{campo.CPF.invalido}")
    private String cpf;
    
    @Column(updatable = false)
    private LocalDate dataNascimento;

    @PrePersist
    public void prePersist(){
        setDataNascimento(LocalDate.now());
    }


}
