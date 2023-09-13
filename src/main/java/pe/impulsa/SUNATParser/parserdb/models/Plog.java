package pe.impulsa.SUNATParser.parserdb.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "log")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Plog {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "ruc")
    Long id;
    @Basic
    @Column(name="periodo")
    Integer periodo;
    @Basic
    @Column(name="cui")
    String cui;
}
